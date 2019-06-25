import DataManager._
import jsonParser._
import LaunchScreen._
import AppUI._

object ScalarStocks {

    val stocksAPIURL = "https://ws-api.iextrading.com/1.0/tops/last?symbols="
    var symbols: Array[String] = Array()

    def main(args: Array[String]) : Unit = {
        makeLaunchScreen()
        loadDataFromLocalFile()
        refreshData(symbols)
    }

    def refreshData(sym: Array[String]) : Unit = {
        val stocksData = getDataFromURLWithSymbols(stocksAPIURL, sym)
        val parsedSymbols = parse(stocksData)
        makeMainUI(parsedSymbols)
    }
}