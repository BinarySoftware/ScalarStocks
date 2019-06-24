import scala.io.Source

object Main {
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

    def main(args: Array[String]) : Unit = {
        val stocksAPIURL = "https://ws-api.iextrading.com/1.0/tops/last?symbols="
        val symbols = Array("AAPL","SNAP","FB")
        

        val stocksData = getDataFromURLWithSymbols(stocksAPIURL, symbols)

        println(stocksData)
    }
}