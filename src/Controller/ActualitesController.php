<?php

namespace App\Controller;

use App\Entity\Actualites;
use App\Entity\Commentaires;
use App\Entity\Personne;
use App\Form\ActualitesFormType;
use App\Form\CommentairesFormType;
use Knp\Component\Pager\PaginatorInterface;
use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Annotation\Route;
use Dompdf\Dompdf;
use Dompdf\Options;

/**
 * Class ActualitesController
 * @package App\Controller
 * @Route("/actualites", name="actualites_")
 */
class ActualitesController extends AbstractController
{
    /**
     * @Route("/", name="articles")
     */
    public function index(Request $request, PaginatorInterface $paginator ): Response
    {
        $donnees =$this->getDoctrine()->getRepository(Actualites::class)->findBy([],['created_at' => 'desc']);

        $actualites = $paginator->paginate(
            $donnees,
            $request->query->getInt('page',1),
            3
        );
        return $this->render('actualites/index.html.twig', [
            'actualites' => $actualites,
        ]);
    }
    /**
     * @Route("/back", name="back")
     */
    public function back(): Response
    {
        $actualites = $this->getDoctrine()
            ->getRepository(Actualites::class)
            ->findAll();

        return $this->render('actualites/backshow.html.twig', [
            'actualites' => $actualites,
        ]);
    }

    /**
     * @Route("/nouveau", name="ajout_article")
     */
    public function ajoutArticle(Request $request){
        $actualite = new Actualites();

        $form = $this->createForm(ActualitesFormType::class, $actualite);
        $form->handleRequest($request);
       // dump($request);
        if($form->isSubmitted() && $form->isValid()){
            $file =$actualite->getFeaturedImage();
            $fileName = md5(uniqid()).'.'.$file->guessExtension();
            try {
                $file->move(
                    $this->getParameter('images_directory'),
                    $fileName
                );
            } catch (FileException $e) {
                // ... handle exception if something happens during file upload
            }
            $actualite->setFeaturedImage($fileName);
            $actualite->setSlug("aaaa");
            $actualite->setCreatedAt(new \DateTime('now'));
            $actualite->setUpdatedAt(new \DateTime('now'));
            $doctrine = $this->getDoctrine()->getManager();
            $doctrine->persist($actualite);
            $doctrine->flush();
        }
        return $this->render('actualites/ajout.html.twig',[
            'form' => $form->createView()
        ]);
    }

    /**
     * @Route("/{id}", name="article")
     */
    public function article($id, Request $request)
    {

        $article = $this->getDoctrine()->getRepository(Actualites::class)->findOneBy(['id' => $id]);
        if(!$article){
           throw $this->createNotFoundException('L\'article n\'existe pas');
        }

        $commentaires = $this->getDoctrine()->getRepository(Commentaires::class)->findBy([
            'actualites' => $article,
            'actif' => 1
        ],['created_at' => 'desc']);

        $commentaire = new Commentaires();
        $form = $this->createForm(CommentairesFormType::class, $commentaire);
        $form->handleRequest($request);
        if($form->isSubmitted() && $form->isValid()){
            $commentaire->setActualites($article);
            $commentaire->setCreatedAt(new \DateTime('now'));

            $doctrine = $this->getDoctrine()->getManager();
            $doctrine->persist($commentaire);
            $doctrine->flush();
            $commentaires = $this->getDoctrine()->getRepository(Commentaires::class)->findBy([
                'actualites' => $article,
                'actif' => 1
            ],['created_at' => 'desc']);
        }
        return $this->render('actualites/article.html.twig', [
            'article' => $article,
            'commentaires' => $commentaires,
            'formComment' => $form->createView()
        ]);
    }

    /**
     * @Route("/{id}/topdf", name="topdf")
     */
    public function articleToPdf($id)
    {
        // Configure Dompdf according to your needs
        $pdfOptions = new Options();
        $pdfOptions->set('defaultFont', 'Arial');

        // Instantiate Dompdf with our options
        $dompdf = new Dompdf($pdfOptions);
        $article = $this->getDoctrine()->getRepository(Actualites::class)->findOneBy(['id' => $id]);
        if(!$article){
            throw $this->createNotFoundException('L\'article n\'existe pas');
        }

        // Retrieve the HTML generated in our twig file
        $html = $this->renderView('actualites/topdf.html.twig', [
            'article' => $article,
        ]);

        // Load HTML to Dompdf
        $dompdf->loadHtml($html);

        // (Optional) Setup the paper size and orientation 'portrait' or 'portrait'
        $dompdf->setPaper('A4', 'portrait');

        // Render the HTML as PDF
        $dompdf->render();

        // Output the generated PDF to Browser (force download)
        $dompdf->stream("mypdf.pdf", [
            "Attachment" => true
        ]);


    }

    /**
     * @Route("/{id}/edit", name="edit")
     */
    public function edit(Request $request, Actualites $actualite): Response
    {
        $form = $this->createForm(ActualitesFormType::class, $actualite);
        $form->handleRequest($request);

        if ($form->isSubmitted() && $form->isValid()) {
            $this->getDoctrine()->getManager()->flush();

            return $this->redirectToRoute('actualites_back');
        }

        return $this->render('actualites/edit.html.twig', [
            'actualite' => $actualite,
            'form' => $form->createView(),
        ]);
    }

    /**
     * @Route("/{id}", name="delete", methods={"POST"})
     */
    public function delete(Request $request, Actualites $actualite): Response
    {
        if ($this->isCsrfTokenValid('delete'.$actualite->getId(), $request->request->get('_token'))) {
            $entityManager = $this->getDoctrine()->getManager();
            $entityManager->remove($actualite);
            $entityManager->flush();
        }

        return $this->redirectToRoute('actualites_back');
    }

}
