import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class MyClassShould {

    @Test
    fun `behave fine`() {
        assertThat(1).isEqualTo(1)
    }

    @Test
    fun `or not`() {
        assertThat(1).isEqualTo(2)
    }
}