import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class BoardShould {

    @Test
    fun `create board from string`() {
        assertEquals(
                Board(),
                Board.createFromString("")
        )
        assertEquals(
                Board(
                        rows = listOf(
                                Row(cells = listOf(Cell(alive = false), Cell(alive = false), Cell(alive = false)))
                        )
                ),
                Board.createFromString("---")
        )
        assertEquals(
                Board(
                        rows = listOf(
                                Row(cells = listOf(Cell(alive = false), Cell(alive = false), Cell(alive = false))),
                                Row(cells = listOf(Cell(alive = false), Cell(alive = true), Cell(alive = false))),
                                Row(cells = listOf(Cell(alive = false), Cell(alive = false), Cell(alive = false)))
                        )
                ),
                Board.createFromString("""
            ---
            -o-
            ---
        """.trimIndent())
        )
        assertEquals(
                Board(
                        rows = listOf(
                                Row(cells = listOf(Cell(alive = false), Cell(alive = false), Cell(alive = true))),
                                Row(cells = listOf(Cell(alive = false), Cell(alive = true), Cell(alive = false))),
                                Row(cells = listOf(Cell(alive = true), Cell(alive = false), Cell(alive = false)))
                        )
                ),
                Board.createFromString("""
            --o
            -o-
            o--
        """.trimIndent())
        )
    }

}