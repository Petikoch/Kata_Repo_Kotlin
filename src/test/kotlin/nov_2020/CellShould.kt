package nov_2020

import Cell
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CellShould {

    @Test
    fun `create dead cell from - character`() {
        val c = '-'

        val result = Cell.createFromChar(c)

        assertEquals(Cell(alive = false), result)
    }

    @Test
    fun `create dead cell from o character`() {
        val c = 'o'

        val result = Cell.createFromChar(c)

        assertEquals(Cell(alive = true), result)
    }

}