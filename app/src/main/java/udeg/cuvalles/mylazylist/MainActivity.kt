
package udeg.cuvalles.mylazylist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import udeg.cuvalles.mylazylist.ui.theme.Data
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

                    MyColumn(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun MyColumn(modifier: Modifier = Modifier) {

    val personas = listOf(

        Data(
            nombre = "Juan Perez",
            description = "Me gusta programar y aprender nuevas tecnologías.",
            likes = 10
        ),

        Data(
            nombre = "Jose Eduardo",
            description = "Me interesa la electrónica y la robótica.",
            likes = 15
        ),

        Data(
            nombre = "Juan Jose",
            description = "Me gusta enseñar y compartir mis conocimientos.",
            likes = 8
        ),

        Data(
            nombre = "Jose Juan",
            description = "Me gusta la informática y trabajar con computadoras.",
            likes = 20
        )
    )

    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),

        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {

        items(personas) { persona ->

            TarjetaPersona(
                persona = persona
            )
        }
    }
}

@Composable
fun TarjetaPersona(persona: Data) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {

            Text(
                text = persona.nombre,
                style = MaterialTheme.typography.headlineSmall
            )

            Spacer(
                modifier = Modifier.height(8.dp)
            )

            Text(
                text = persona.description
            )

            Spacer(
                modifier = Modifier.height(12.dp)
            )

            Text(
                text = " ${persona.likes} likes"
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {

    MyLazylistTheme {
        MyColumn()
    }
}

