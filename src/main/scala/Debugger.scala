object Debugger {
    abstract class DebuggerType

    case class Info() extends DebuggerType
    case class Warning() extends DebuggerType
    case class Error() extends DebuggerType
    case class Success() extends DebuggerType

    def viewer(message: String, debugType: DebuggerType) : Unit = {
        val color = debugType match {
            case Info() => Console.BLUE
            case Warning() => Console.YELLOW
            case Error() => Console.RED
            case Success() => Console.GREEN
            case _ => Console.WHITE
        }

        println(color + "\n" + message)
        Thread.sleep(2000)

        if (debugType == Error()) {
            System.exit(0)
        }
    }
}