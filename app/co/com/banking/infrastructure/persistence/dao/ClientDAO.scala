package co.com.banking.infrastructure.persistence.dao

import co.com.banking.infrastructure.persistence.models.Client
import javax.inject.Inject
import play.api.db.slick.{DatabaseConfigProvider, HasDatabaseConfigProvider}
import slick.jdbc.JdbcProfile

import scala.concurrent.{ExecutionContext, Future}

class ClientDAO @Inject() (protected val dbConfigProvider: DatabaseConfigProvider)(implicit executionContext: ExecutionContext) extends HasDatabaseConfigProvider[JdbcProfile] {

  import profile.api._

  private val Clients = TableQuery[ClientsTable]

  def all(): Future[Seq[Client]] = db.run(Clients.result)

  def insert(client: Client): Future[Unit] = db.run(Clients += client).map { _ => () }

  private class ClientsTable(tag: Tag) extends Table[Client](tag, "client") {

    def name = column[String]("name", O.PrimaryKey)

    def lastName = column[String]("lastname")

    def * = (name, lastName) <> (Client.tupled, Client.unapply)

  }
}
