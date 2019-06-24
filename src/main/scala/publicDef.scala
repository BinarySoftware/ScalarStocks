import scala.sys.process._

object PublicDef {
    def clear() = "clear".!

    case class Symbol(symbol: String, price: Double, size: Int, time: Long)
}