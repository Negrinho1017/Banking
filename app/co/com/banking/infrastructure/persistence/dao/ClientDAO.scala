package co.com.banking.infrastructure.persistence.dao

import javax.inject.Inject
import play.api.db.slick.{DatabaseConfigProvider, HasDatabaseConfigProvider}
import slick.jdbc.JdbcProfile
import co.com.banking.infrastructure.persistence.models.Client
import scala.concurrent.{ExecutionContext, Future}

class ClientDAO @Inject() (protected val dbConfigProvider: DatabaseConfigProvider)(implicit executionContext: ExecutionContext) extends HasDatabaseConfigProvider[JdbcProfile] {

  import profile.api._

  private val Clients = TableQuery[ClientsTable]

  def all(): Future[Seq[Client]] = db.run(Clients.result)

  def insert(client: Client): Future[Unit] = db.run(Clients += client).map { _ => () }


  private class ClientsTable(tag: Tag) extends Table[Client](tag, "client") {

    def identificationNumber = column[String]("identification_number", O.PrimaryKey)
    def name = column[String]("name")
    def lastName = column[String]("last_name")

    def * = (identificationNumber, name, lastName) <> ((Client.apply _).tupled, Client.unapply)

  }

}
