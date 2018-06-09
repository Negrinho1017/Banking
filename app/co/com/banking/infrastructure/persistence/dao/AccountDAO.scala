package co.com.banking.infrastructure.persistence.dao

import javax.inject.Inject
import play.api.db.slick.{DatabaseConfigProvider, HasDatabaseConfigProvider}
import slick.jdbc.JdbcProfile
import co.com.banking.infrastructure.persistence.dto.{AccountDto}

import scala.concurrent.{ExecutionContext, Future}


class AccountDAO @Inject() (protected val dbConfigProvider: DatabaseConfigProvider)(implicit executionContext: ExecutionContext)
  extends HasDatabaseConfigProvider[JdbcProfile] {

  import profile.api._

  private val Accounts = TableQuery[AccountsTable]

  def allAccounts(): Future[Seq[AccountDto]] = db.run(Accounts.result)

  def insertAccount(account: AccountDto): Future[Unit] = db.run(Accounts += account).map { _ => () }

  def findByAccountNumber(accountNumber: String): Future[Option[AccountDto]] =
    db.run(Accounts.filter(_.accountNumber === accountNumber).result.headOption)

  private class AccountsTable(tag: Tag) extends Table[AccountDto](tag, "account") {

    def accountNumber = column[String]("account_number", O.PrimaryKey)
    def typeAccount = column[Option[String]]("type_account")
    def state = column[Option[String]]("state")
    def balance = column[Option[Double]]("balance")

    def * = (accountNumber, typeAccount, state, balance) <> ((AccountDto.apply _).tupled, AccountDto.unapply)

  }

}
