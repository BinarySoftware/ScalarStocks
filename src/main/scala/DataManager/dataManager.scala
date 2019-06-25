import scala.io.Source
import ScalarStocks._

object DataManager {
    def getDataFromURLWithSymbols(urlString: String, symbols: Array[String]) : String = {
        val stringOfSymbols = symbols.mkString(",")
        val concatenatedURL = urlString.concat(stringOfSymbols)

        try {
            Source.fromURL(concatenatedURL).mkString
        }
        catch {
            case _ : Throwable => "An error has occurred"
        }
    }

    def saveDataToLocalFile() : String = {
        return "Success"
    }

    def loadDataFromLocalFile() : String = {
        return "Success"
    }
}