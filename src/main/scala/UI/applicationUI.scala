import PublicDef._
import java.util.Date
import ScalarStocks._

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
        println("\n" + Console.BLUE + "  NAME    PRICE    TIME OF LAST REFRESH")

        for (symbol <- symbols) {
            val lastRefreshTimeReadable = new Date(symbol.time * 1000L)
            println("  " + Console.GREEN + symbol.symbol.formatted(s"%-8s") + Console.WHITE + "%.2f".format(symbol.price).formatted(s"%-9s") + lastRefreshTimeReadable)
        }
    }

    def makeControlsForMainScreen() : Unit = {
        println()
        println(Console.YELLOW + "[R]" + Console.WHITE + "efresh " + Console.YELLOW + "[A]" + Console.WHITE + "dd symbols " + Console.YELLOW + "[D]" + Console.WHITE + "elete symbols " + Console.YELLOW + "[Q]" + Console.WHITE + "uit")
        println()
        makePrompt()
    }

    def makePrompt() {
        val action = scala.io.StdIn.readLine()
        if (action == "R" || action == "r") {
            refreshData(symbols)
        } else if (action == "A" || action == "a") {
            println(Console.BLUE + "Under construction - add")
        } else if (action == "D" || action == "d") {
            println(Console.BLUE + "Under construction - delete")
        } else if (action == "Q" || action == "q") {
            println(Console.RED + "Are you sure you want to quit? (Y/N)")
            val quitAction = scala.io.StdIn.readLine()

            if (quitAction == "Y" || quitAction == "y") {
                System.exit(0)
            } else {
                refreshData(symbols)
            }
        } else {
            println(Console.RED + "Sorry, I dont know what you mean by: " + action)
            makeControlsForMainScreen()
        }
    }
}