<?php

namespace App\Controller;

use App\Entity\Recherche;
use App\Entity\Reclamation;
use App\Form\RechercheformType;
use App\Form\ReclamationType;
use App\Repository\ReclamationRepository;
use Symfony\Bundle\FrameworkBundle\Controller\Controller;
use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Annotation\Route;
use Symfony\Component\Form\FormBuilderInterface;
use Symfony\Component\Form\FormInterface;
use Symfony\Component\Form\Extension\Core\Type\TextType;
use Knp\Component\Pager\PaginatorInterface;



/**
 * @Route("/reclamation")
 */
class ReclamationController extends Controller
{
    /**
     * @Route("/", name="reclamation_index", methods={"GET","POST"})
     * @param ReclamationRepository $reclamationRepository
     * @param $request
     * @return Response
     */
    public function index(ReclamationRepository $reclamationRepository,Request $request): Response
    {

        $formsearch=$this->createForm(RechercheformType::class);
        $search=$formsearch->handleRequest($request);
        if($formsearch->isSubmitted() && $formsearch->isValid())
        {
            $reclamations=$reclamationRepository->search($search->get('mots')->getData());


        }
        else{
            $reclamations=$reclamationRepository->findAll();
        }





       return $this->render('reclamation/index.html.twig', [
            'reclamations' => $reclamations,
           'form'=>$formsearch->createView(),
        ]);



           }



    /**
     * @Route("/new", name="reclamation_new", methods={"GET","POST"})
     */
    public function new(Request $request): Response
    {
        $reclamation = new Reclamation();
        $form = $this->createForm(ReclamationType::class, $reclamation);
        $form->handleRequest($request);

        if ($form->isSubmitted() && $form->isValid()) {
            $entityManager = $this->getDoctrine()->getManager();
            $entityManager->persist($reclamation);
            $entityManager->flush();

            return $this->redirectToRoute('reclamation_index');
        }

        return $this->render('reclamation/new.html.twig', [
            'reclamation' => $reclamation,
            'form' => $form->createView(),
        ]);
    }

    /**
     * @Route("/{id}", name="reclamation_show", methods={"GET"})
     */
    public function show(Reclamation $reclamation): Response
    {
        return $this->render('reclamation/show.html.twig', [
            'reclamation' => $reclamation,
        ]);
    }

    /**
     * @Route("/{id}/edit", name="reclamation_edit", methods={"GET","POST"})
     */
    public function edit(Request $request, Reclamation $reclamation): Response
    {
        $form = $this->createForm(ReclamationType::class, $reclamation);
        $form->handleRequest($request);

        if ($form->isSubmitted() && $form->isValid()) {
            $this->getDoctrine()->getManager()->flush();

            return $this->redirectToRoute('reclamation_index');
        }

        return $this->render('reclamation/edit.html.twig', [
            'reclamation' => $reclamation,
            'form' => $form->createView(),
        ]);
    }


    /**
     * @Route("/{id}", name="reclamation_delete", methods={"POST"})
     */
    public function delete(Request $request, Reclamation $reclamation): Response
    {
        if ($this->isCsrfTokenValid('delete'.$reclamation->getId(), $request->request->get('_token'))) {
            $entityManager = $this->getDoctrine()->getManager();
            $entityManager->remove($reclamation);
            $entityManager->flush();
        }

        return $this->redirectToRoute('reclamation_index');
    }

}



