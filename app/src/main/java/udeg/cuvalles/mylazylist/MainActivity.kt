package udeg.cuvalles.mylazylist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import udeg.cuvalles.mylazylist.ui.theme.MyLazylistTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        setContent {
            MyLazylistTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize()
                ) { innerPadding ->

                    myColum(
                        modifier = Modifier.padding(innerPadding)
                    )
                    //mandar a llamar a funcion  de Rows
                    myRowLazy(
                        modifier = Modifier.padding()
                    )
                }
            }
        }
    }
}

@Composable
fun myColum(modifier: Modifier = Modifier) {

    val datos01 = listOf(
        "Lunes",
        "Martes",
        "Miércoles",
        "Jueves",
        "Viernes",
        "Sábado",
        "Domingo"
    )
30
    LazyColumn(
        modifier = modifier
            .fillMaxWidth()
            .height(120.dp)
    ) {

        item {
            Text(
                text = "Días de la semana"
            )
        }

        items(datos01) { item ->
            Text(
                text = item
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {

    MyLazylistTheme {
        myColum()
    }
}

