<?php

namespace App\Entity;

use App\Repository\ReclamationRepository;
use Doctrine\ORM\Mapping as ORM;

/**
 * @ORM\Entity(repositoryClass=ReclamationRepository::class)
 * @Orm\Table(name="`reclamation`",indexes={@ORM\Index(columns={"sujet"}, flags={"fulltext"})})
 */
class Reclamation
{
    /**
     * @ORM\Id
     * @ORM\GeneratedValue
     * @ORM\Column(type="integer")
     */
    private $id;

    /**
     * @ORM\Column(type="integer", nullable=true)
     */
    private $id_user;

    /**
     * @ORM\Column(type="integer", nullable=true)
     */
    private $id_produit;

    /**
     * @ORM\Column(type="string", length=255, nullable=true)
     */
    private $message;

    /**
     * @ORM\Column(type="string", length=255, nullable=true)
     */
    private $sujet;

    /**
     * @ORM\Column(type="integer", nullable=true)
     */
    private $id_moderateur;

    public function getId(): ?int
    {
        return $this->id;
    }

    public function getIdUser(): ?int
    {
        return $this->id_user;
    }

    public function setIdUser(?int $id_user): self
    {
        $this->id_user = $id_user;

        return $this;
    }

    public function getIdProduit(): ?int
    {
        return $this->id_produit;
    }

    public function setIdProduit(?int $id_produit): self
    {
        $this->id_produit = $id_produit;

        return $this;
    }

    public function getMessage(): ?string
    {
        return $this->message;
    }

    public function setMessage(?string $message): self
    {
        $this->message = $message;

        return $this;
    }

    public function getSujet(): ?string
    {
        return $this->sujet;
    }

    public function setSujet(?string $sujet): self
    {
        $this->sujet = $sujet;

        return $this;
    }

    public function getIdModerateur(): ?int
    {
        return $this->id_moderateur;
    }

    public function setIdModerateur(?int $id_moderateur): self
    {
        $this->id_moderateur = $id_moderateur;

        return $this;
    }
}
