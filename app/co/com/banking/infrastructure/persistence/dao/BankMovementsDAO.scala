package co.com.banking.infrastructure.persistence.dao

import javax.inject.Inject
import play.api.db.slick.{DatabaseConfigProvider, HasDatabaseConfigProvider}
import slick.jdbc.JdbcProfile
import co.com.banking.infrastructure.persistence.dto.{AccountDto, BankMovementsDto}

import scala.concurrent.{ExecutionContext, Future}


class BankMovementsDAO @Inject() (protected val dbConfigProvider: DatabaseConfigProvider)(implicit executionContext: ExecutionContext)
  extends HasDatabaseConfigProvider[JdbcProfile] {

  import profile.api._

  private val bankMovements = TableQuery[BankMovementsTable]

  def allMovements(): Future[Seq[BankMovementsDto]] = db.run(bankMovements.result)

  def insertNewMovement(bankMovement: BankMovementsDto): Future[Unit] = db.run(bankMovements += bankMovement).map { _ => () }


  private class BankMovementsTable(tag: Tag) extends Table[BankMovementsDto](tag, "bank_movements") {

    def codeMovement = column[String]("code_movement", O.PrimaryKey)
    def movementType = column[Option[String]]("movement_type")
    def rootAccount = column[Option[String]]("root_account")
    def destinationAccount = column[Option[String]]("destination_account")
    def amount = column[Option[Double]]("amount")

    def * = (codeMovement, movementType, rootAccount, destinationAccount, amount) <> ((BankMovementsDto.apply _).tupled, BankMovementsDto.unapply)

  }

}
