<?php

declare(strict_types=1);

namespace DoctrineMigrations;

use Doctrine\DBAL\Schema\Schema;
use Doctrine\Migrations\AbstractMigration;

/**
 * Auto-generated Migration: Please modify to your needs!
 */
final class Version20210421155918 extends AbstractMigration
{
    public function getDescription() : string
    {
        return '';
    }

    public function up(Schema $schema) : void
    {
        // this up() migration is auto-generated, please modify it to your needs
        $this->addSql('ALTER TABLE actualites DROP FOREIGN KEY FK_75315B6D146AD7BC');
        $this->addSql('DROP INDEX IDX_75315B6D146AD7BC ON actualites');
        $this->addSql('ALTER TABLE actualites DROP personnes_id');
    }

    public function down(Schema $schema) : void
    {
        // this down() migration is auto-generated, please modify it to your needs
        $this->addSql('ALTER TABLE actualites ADD personnes_id INT NOT NULL');
        $this->addSql('ALTER TABLE actualites ADD CONSTRAINT FK_75315B6D146AD7BC FOREIGN KEY (personnes_id) REFERENCES personne (id)');
        $this->addSql('CREATE INDEX IDX_75315B6D146AD7BC ON actualites (personnes_id)');
    }
}
