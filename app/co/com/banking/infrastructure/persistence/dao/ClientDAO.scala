package co.com.banking.infrastructure.persistence.dao

import co.com.banking.domain.entities.client.IdentificationNumber
import javax.inject.Inject
import play.api.db.slick.{DatabaseConfigProvider, HasDatabaseConfigProvider}
import slick.jdbc.JdbcProfile
import co.com.banking.infrastructure.persistence.dto.ClientDto

import scala.concurrent.{ExecutionContext, Future}


class ClientDAO @Inject() (protected val dbConfigProvider: DatabaseConfigProvider)(implicit executionContext: ExecutionContext)
  extends HasDatabaseConfigProvider[JdbcProfile] {

  import profile.api._

  private val Clients = TableQuery[ClientsTable]

  def all(): Future[Seq[ClientDto]] = db.run(Clients.result)

  def insert(client: ClientDto): Future[Unit] = db.run(Clients += client).map { _ => () }

  def findByIdentificationNumber(identificationNumber: String): Future[Option[ClientDto]] =
    db.run(Clients.filter(_.identificationNumber === identificationNumber).result.headOption)

  private class ClientsTable(tag: Tag) extends Table[ClientDto](tag, "client") {



    def identificationNumber = column[String]("identification_number", O.PrimaryKey)
    def name = column[Option[String]]("name")
    def lastName = column[Option[String]]("last_name")
    def cellphone = column[Option[String]]("cellphone")
    def account = column[Option[String]]("account")
    //def birthdate = column[Date]("birthdate")

    def * = (identificationNumber, name, lastName, cellphone, account) <> ((ClientDto.apply _).tupled, ClientDto.unapply)

  }

}
