const val aliveChar = 'o'
const val deadChar = '-'

fun main() {
    var situation = """
            -----
            -ooo-
            -----
        """.trimIndent()

    repeat(10) {
        val nextGenBoard = Board.createFromString(situation).nextGeneration()
        println(nextGenBoard)
        println()
        situation = nextGenBoard.toString()
    }
}

data class Cell(val alive: Boolean = false) {
    companion object {
        fun createFromChar(c: Char): Cell {
            if (c == deadChar) {
                return Cell(alive = false)
            }
            if (c == aliveChar) {
                return Cell(alive = true)
            }
            throw IllegalArgumentException("Unhandled $c")
        }
    }

    override fun toString(): String {
        if (alive) {
            return aliveChar.toString()
        }
        return deadChar.toString()
    }
}

data class Row(val cells: List<Cell> = emptyList()) {
    companion object {
        fun createFromString(s: String): Row {
            return Row(cells = s.toCharArray().asList().map { Cell.createFromChar(it) })
        }
    }

    override fun toString(): String {
        return cells.joinToString(separator = "") { cell -> cell.toString() }
    }

    fun isAlive(cellIndex: Int): Boolean {
        if (cellIndex >= 0 && cellIndex < cells.size) {
            return cells[cellIndex].alive
        }
        return false
    }
}

data class Board(val rows: List<Row> = emptyList()) {
    companion object {
        fun createFromString(s: String): Board {
            if (s.isBlank()) {
                return Board()
            }
            return Board(rows = s.lines().map { Row.createFromString(it) })
        }
    }

    fun nextGeneration(): Board {
        val newRows = rows.mapIndexed { rowIndex, row ->
            Row(row.cells.mapIndexed { cellIndex, cell -> Cell(calculateLiveness(cell.alive, rowIndex, cellIndex)) })
        }
        return Board(newRows)
    }

    private fun calculateLiveness(isAlive: Boolean, rowIndex: Int, cellIndex: Int): Boolean {
        if (isAlive) {
            if (numberOfAliveNeighbors(rowIndex, cellIndex) < 2) {
                return false
            }
            if (numberOfAliveNeighbors(rowIndex, cellIndex) == 2 || numberOfAliveNeighbors(rowIndex, cellIndex) == 3) {
                return true
            }
            if (numberOfAliveNeighbors(rowIndex, cellIndex) > 3) {
                return false
            }
        }

        if (numberOfAliveNeighbors(rowIndex, cellIndex) == 3) {
            return true
        }

        return false
    }

    private fun numberOfAliveNeighbors(rowIndex: Int, cellIndex: Int): Int {
        var count = 0

        if (isAlive(rowIndex - 1, cellIndex - 1)) {
            count++
        }
        if (isAlive(rowIndex - 1, cellIndex)) {
            count++
        }
        if (isAlive(rowIndex - 1, cellIndex + 1)) {
            count++
        }

        if (isAlive(rowIndex, cellIndex - 1)) {
            count++
        }
        if (isAlive(rowIndex, cellIndex + 1)) {
            count++
        }

        if (isAlive(rowIndex + 1, cellIndex - 1)) {
            count++
        }
        if (isAlive(rowIndex + 1, cellIndex)) {
            count++
        }
        if (isAlive(rowIndex + 1, cellIndex + 1)) {
            count++
        }

        return count
    }

    private fun isAlive(rowIndex: Int, cellIndex: Int): Boolean {
        if (rowIndex >= 0 && rowIndex < rows.size) {
            return rows[rowIndex].isAlive(cellIndex)
        }
        return false
    }

    override fun toString(): String {
        return rows.joinToString(separator = "\n") { row -> row.toString() }
    }
}