import DataLoader._
import jsonParser._

object ScalarStocks {

    val stocksAPIURL = "https://ws-api.iextrading.com/1.0/tops/last?symbols="

    def main(args: Array[String]) : Unit = {
        val symbols = Array("PL","SNAP","FB")

        val stocksData = getDataFromURLWithSymbols(stocksAPIURL, symbols)

        val parsedSymbols = parse(stocksData) match {
            case Some(symbols) => symbols
            case None => println("Error while parsing")
        }

        println(parsedSymbols)
    }
}