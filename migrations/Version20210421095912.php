<?php

declare(strict_types=1);

namespace DoctrineMigrations;

use Doctrine\DBAL\Schema\Schema;
use Doctrine\Migrations\AbstractMigration;

/**
 * Auto-generated Migration: Please modify to your needs!
 */
final class Version20210421095912 extends AbstractMigration
{
    public function getDescription() : string
    {
        return '';
    }

    public function up(Schema $schema) : void
    {
        // this up() migration is auto-generated, please modify it to your needs
        $this->addSql('CREATE TABLE actualites_mots_cles (actualites_id INT NOT NULL, mots_cles_id INT NOT NULL, INDEX IDX_BA519BD32EDF1993 (actualites_id), INDEX IDX_BA519BD3C0BE80DB (mots_cles_id), PRIMARY KEY(actualites_id, mots_cles_id)) DEFAULT CHARACTER SET utf8mb4 COLLATE `utf8mb4_unicode_ci` ENGINE = InnoDB');
        $this->addSql('CREATE TABLE actualites_categories (actualites_id INT NOT NULL, categories_id INT NOT NULL, INDEX IDX_5EF65BF52EDF1993 (actualites_id), INDEX IDX_5EF65BF5A21214B7 (categories_id), PRIMARY KEY(actualites_id, categories_id)) DEFAULT CHARACTER SET utf8mb4 COLLATE `utf8mb4_unicode_ci` ENGINE = InnoDB');
        $this->addSql('ALTER TABLE actualites_mots_cles ADD CONSTRAINT FK_BA519BD32EDF1993 FOREIGN KEY (actualites_id) REFERENCES actualites (id) ON DELETE CASCADE');
        $this->addSql('ALTER TABLE actualites_mots_cles ADD CONSTRAINT FK_BA519BD3C0BE80DB FOREIGN KEY (mots_cles_id) REFERENCES mots_cles (id) ON DELETE CASCADE');
        $this->addSql('ALTER TABLE actualites_categories ADD CONSTRAINT FK_5EF65BF52EDF1993 FOREIGN KEY (actualites_id) REFERENCES actualites (id) ON DELETE CASCADE');
        $this->addSql('ALTER TABLE actualites_categories ADD CONSTRAINT FK_5EF65BF5A21214B7 FOREIGN KEY (categories_id) REFERENCES categories (id) ON DELETE CASCADE');
        $this->addSql('ALTER TABLE commentaires ADD actualites_id INT NOT NULL');
        $this->addSql('ALTER TABLE commentaires ADD CONSTRAINT FK_D9BEC0C42EDF1993 FOREIGN KEY (actualites_id) REFERENCES actualites (id)');
        $this->addSql('CREATE INDEX IDX_D9BEC0C42EDF1993 ON commentaires (actualites_id)');
    }

    public function down(Schema $schema) : void
    {
        // this down() migration is auto-generated, please modify it to your needs
        $this->addSql('DROP TABLE actualites_mots_cles');
        $this->addSql('DROP TABLE actualites_categories');
        $this->addSql('ALTER TABLE commentaires DROP FOREIGN KEY FK_D9BEC0C42EDF1993');
        $this->addSql('DROP INDEX IDX_D9BEC0C42EDF1993 ON commentaires');
        $this->addSql('ALTER TABLE commentaires DROP actualites_id');
    }
}
