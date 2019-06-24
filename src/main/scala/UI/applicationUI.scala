import PublicDef._
import java.util.Date

object AppUI {
    def makeMainUI(symbols: Option[List[Symbol]]) : Unit = {
        clear()

        val symbolsList = symbols match {
            case Some(symbol) => symbol
            case None => List[Symbol]()
        }
        
        makeTableFromSymbols(symbolsList)
        makeControlsForMainScreen()
    }

    def makeTableFromSymbols(symbols: List[Symbol]) : Unit = {
        println(Console.BLUE + "NAME   PRICE    TIME OF LAST REFRESH")

        for (symbol <- symbols) {
            val lastRefreshTimeReadable = new Date(symbol.time * 1000L)
            println(Console.GREEN + symbol.symbol + "   " + Console.WHITE + "%.2f".format(symbol.price) + "   " + lastRefreshTimeReadable)
        }
    }

    def makeControlsForMainScreen() : Unit = {
        println()
        println(Console.YELLOW + "[R]" + Console.WHITE + "efresh " + Console.YELLOW + "[A]" + Console.WHITE + "dd symbols " + Console.YELLOW + "[D]" + Console.WHITE + "elete symbols " + Console.YELLOW + "[Q]" + Console.WHITE + "uit")
        println()
    }
}