import scala.io.Source

object Main {
    def main(args: Array[String]) : Unit = {
        val stocksAPIURL = "https://ws-api.iextrading.com/1.0/tops/last?symbols="
        val symbols = Array("AAPL","SNAP","FB")
        val combinedURL = stocksAPIURL.concat(symbols.mkString(","))

        println(combinedURL)

        val stocksData = Source.fromURL(combinedURL).mkString
        println(stocksData)
    }
}