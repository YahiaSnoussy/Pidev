<?php


namespace App\Controller;
use App\Entity\Contact;
use App\Services\MailerService;
use App\Services\MessageService;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\Routing\Annotation\Route;
use App\Form\ContactType;
use App\Manager\ContactManager;
use Doctrine\ORM\EntityManagerInterface;
use Symfony\Component\Form\FormInterface;

class MailSendingController extends AbstractController
{
    /**
     * @Route("/mail", name="mail", methods={"GET"})
     */
    public function mail( Request $request,
                          ContactManager $contactManager,
                          MailerService $mailerService,
                          MessageService $messageService, ):Response
    {/**
     * @Route("/mail", name="contact",methods={"GET","POST"})
     * @param Request $request
     * @param ContactManager $contactManager
     * @return Response
     */





        $contact = new Contact();
        $formContact = $this->createForm(ContactType::class, null);
        $formContact->handleRequest($request);

        if ($formContact->isSubmitted() && $formContact->isValid()) {
            $data=$formContact->getData();
            $mailerService->send(
                "nouveau message",
                "dsioho@app.com",
                "HAHA@mailinator.com",
                "search.html.twig",
                [
                    "name"=>$data->getName(),
                    "email"=>$data->getEmail(),
                    "description"=>$data->getDescription()
                ]
            );
            $messageService->addSuccess('votre message est envoyé avec succès!');
            return $this->redirectToRoute('reclamation_index');
        }

        return $this->render('reclamation/mail.html.twig', [
            'formContact' => $formContact->createView()
        ]);
    }

}