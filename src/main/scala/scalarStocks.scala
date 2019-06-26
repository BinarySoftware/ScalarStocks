import DataManager._
import jsonParser._
import LaunchScreen._
import AppUI._
import Message._
import PublicDef._

object ScalarStocks {
    var symbols: Array[String] = Array()

    def main(args: Array[String]) : Unit = {
        makeLaunchScreen()
        loadDataFromLocalFile()
        refreshData(symbols)
    }

    def refreshData(sym: Array[String]) : Unit = {
        val stocksData = getDataFromURLWithSymbols(baseURL, sym)
        if (stocksData == ERROR_BASE_MSG && sym.length != 0) {
            viewMessage(FETCH_ERROR_MSG, Error(),1)
        }
        val parsedSymbols = parse(stocksData)
        makeMainUI(parsedSymbols)
    }
}