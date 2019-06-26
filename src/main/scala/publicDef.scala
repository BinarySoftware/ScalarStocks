import scala.sys.process._

object PublicDef {
    def clear() = "clear".!

    val baseURL = "https://ws-api.iextrading.com/1.0/tops/last?symbols="
    val dataFileName = "symbols.txt"
    
    val ERROR_BASE_MSG = "An error has occured"
    val FETCH_ERROR_MSG = "Unable to fetch data from server"
    val NO_DATA_INFORMATION = "\n\nFirst, you need to append symbols. Do that by clicking [A] and typing in symbol name"

    case class Symbol(symbol: String, price: Double, size: Int, time: Long)
}