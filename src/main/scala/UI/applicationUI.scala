import PublicDef._
import java.util.Date
import ScalarStocks._
import DataManager._
import Message._

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
            val lastRefreshTimeReadable = new Date(symbol.time)
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
        val action = scala.io.StdIn.readLine(Console.BLUE + "Command>")

        if (action == "R" || action == "r") {
            viewMessage("Successfull refresh",Success())
            refreshData(symbols)
        } else if (action == "A" || action == "a") {
            viewMessage("Please type in correct symbol to append",Other())
            var symbolName = scala.io.StdIn.readLine(Console.BLUE + "Symbol>")
            symbolName = symbolName.toUpperCase

            if (symbols.contains(symbolName)) {
                viewMessage("Sorry, your symbols already contain: " +  symbolName,Warning(),1)
                makeControlsForMainScreen()
            } else {
                symbols :+= symbolName
                saveDataToLocalFile()
                viewMessage("Successfully appended: " +  symbolName,Success())
                refreshData(symbols)
            }
        } else if (action == "D" || action == "d") {
            viewMessage("Please type in correct symbol to delete",Other())
            var symbolName = scala.io.StdIn.readLine(Console.BLUE + "Symbol>")
            symbolName = symbolName.toUpperCase

            if (symbols.contains(symbolName)) {
                symbols = symbols.filter(! _.contains(symbolName))
                saveDataToLocalFile()
                viewMessage("Successfully removed: " +  symbolName,Success())
                refreshData(symbols)
            } else {
                viewMessage("Sorry, there is no " +  symbolName + " in your symbols array",Warning(),1)
                makeControlsForMainScreen()
                
            }
        } else if (action == "Q" || action == "q") {
            viewMessage("Are you sure you want to quit? (Y/N)",Warning())
            val quitAction = scala.io.StdIn.readLine(Console.BLUE + "Command>")

            if (quitAction == "Y" || quitAction == "y") {
                System.exit(0)
            } else {
                refreshData(symbols)
            }
        } else {
            viewMessage("Sorry, I dont know what you mean by: " + action,Warning(),1)
            makeControlsForMainScreen()
        }
    }
}