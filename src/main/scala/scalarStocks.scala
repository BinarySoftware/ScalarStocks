import DataLoader._

object ScalarStocks {
    def main(args: Array[String]) : Unit = {
        val stocksAPIURL = "https://ws-api.iextrading.com/1.0/tops/last?symbols="
        val symbols = Array("AAPL","SNAP","FB")
        

        val stocksData = getDataFromURLWithSymbols(stocksAPIURL, symbols)

        println(stocksData)
    }
}