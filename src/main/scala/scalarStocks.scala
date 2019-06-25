import DataManager._
import jsonParser._
import LaunchScreen._
import AppUI._
import Debugger._

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
        if (stocksData == "An error has occurred") {
            viewer("Unable to fetch data from server", "error")
        }
        val parsedSymbols = parse(stocksData)
        makeMainUI(parsedSymbols)
    }
}