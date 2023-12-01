package js.apps.guessthevalue.data


import js.apps.guessthevalue.R
import js.apps.guessthevalue.model.Player
import js.apps.guessthevalue.model.Teams

class PlayersProvider {

    fun createPremPlayersList(randomSet: List<Int>): List<Player> {

        val premPlayersList = mutableListOf<Player>()
        randomSet.forEach {
            premPlayersList.add(playersPremier[it])
        }
        for (i in 1 until premPlayersList.size) {
            if (premPlayersList[i].marketPrice == premPlayersList[i - 1].marketPrice) {
                // Encuentra un jugador con un valor diferente y lo intercambia
                val jugadorDiferente = premPlayersList.firstOrNull { it.marketPrice != premPlayersList[i].marketPrice }
                jugadorDiferente?.let {
                    // Intercambia los jugadores
                    val indiceJugadorDiferente = premPlayersList.indexOf(it)
                    val temp = premPlayersList[indiceJugadorDiferente]
                    premPlayersList[indiceJugadorDiferente] = premPlayersList[i]
                    premPlayersList[i] = temp
                }
            }
        }
        return premPlayersList
    }

    //84 jugadores(26/11/2023 04:13)

    private val playersPremier = listOf(
        Player(
            name = "Declan Rice",
            marketPrice = 100,
            equipo = Teams.ARS,
            pic =  R.drawable.declan_rice
        ),Player(
            name = "Phil Foden",
            marketPrice = 100,
            equipo = Teams.MCI,
            pic =  R.drawable.phil_foden
        ),
        Player(
            name = "Ivan Toney",
            marketPrice = 40,
            equipo = Teams.BRE,
            pic =  R.drawable.enzo_fernandez
        ),
        Player(
            name = "Heung-Min Son",
            marketPrice = 50,
            equipo = Teams.TOT,
            pic =  R.drawable.son_heung,
            isPlayerLeft = false
        ),
        Player(
            name = "Harry Kane",
            marketPrice = 80,
            equipo = Teams.TOT,
            pic =  R.drawable.harry_kane
        ),
        Player(
            name = "Erling Haaland",
            marketPrice = 180,
            equipo = Teams.MCI,
            pic =  R.drawable.haaland,
            isPlayerLeft = false
        ),
        Player(
            name = "Josko Gvardiol",
            marketPrice = 80,
            equipo = Teams.MCI,
            pic =  R.drawable.haaland,
            isPlayerLeft = false
        ),
        Player(
            name = "Darwin Núñez",
            marketPrice = 65,
            equipo = Teams.LIV,
            pic =  R.drawable.haaland,
            isPlayerLeft = false
        ),
        Player(
            name = "Bukayo Saka",
            marketPrice = 120,
            equipo = Teams.ARS,
            pic =  R.drawable.saka
        ),
        Player(
            name = "Martin Ødegaard",
            marketPrice = 90,
            equipo = Teams.ARS,
            pic =  R.drawable.martin_odegaard
        ),
        Player(
            name = "Dominik Szoboszlai",
            marketPrice = 70,
            equipo = Teams.LIV,
            pic =  R.drawable.szobozlai,
            isPlayerLeft = false
        ),
        Player(
            name = "Marcus Rashford",
            marketPrice = 75,
            equipo = Teams.MUN,
            pic =  R.drawable.marcus_rashford,
            isPlayerLeft = false
        ),
        Player(
            name = "Enzo Fernández",
            marketPrice = 80,
            equipo = Teams.CHE,
            pic =  R.drawable.enzo_fernandez
        ),
        Player(
            name = "Luís Díaz",
            marketPrice = 75,
            equipo = Teams.LIV,
            pic = R.drawable.luis_diaz,
            isPlayerLeft = false
        ),
        Player(
            name = "Moisés Caicedo",
            marketPrice = 90,
            equipo = Teams.CHE,
            pic = R.drawable.moises_caicedo,
            isPlayerLeft = false
        ),
        Player(
            name = "Gabriel Jesús",
            marketPrice = 75,
            equipo = Teams.ARS,
            pic = R.drawable.gabriel_jesus
        ),
        Player(
            name = "Bruno Fernandes",
            marketPrice = 75,
            equipo = Teams.MUN,
            pic = R.drawable.bruno_fernandes
        ),
        Player(
            name = "Jack Grealish",
            marketPrice = 75,
            equipo = Teams.MCI,
            pic = R.drawable.jack_grealish,
            isPlayerLeft = false
        ),
        Player(
            name = "Bruno Guimaraes",
            marketPrice = 80,
            equipo = Teams.NEW,
            pic = R.drawable.guimaraes,
            isPlayerLeft = false
        ),
        Player(
            name = "Kevin De Bruyne",
            marketPrice = 70,
            equipo = Teams.MCI,
            pic = R.drawable.kdb,
            isPlayerLeft = false
        ),
        Player(
            name = "William saliba",
            marketPrice = 70,
            equipo = Teams.ARS,
            pic = R.drawable.saliba,
            isPlayerLeft = false
        ),
        Player(
            name = "Trent Alexander-Arnold",
            marketPrice = 65,
            equipo = Teams.ARS,
            pic = R.drawable.trent_arnold
        ),
        Player(
            name = "Reece James",
            marketPrice = 65,
            equipo = Teams.CHE,
            pic = R.drawable.reece_james
        ),
        Player(
            name = "Alexander Isak",
            marketPrice = 70,
            equipo = Teams.NEW,
            pic = R.drawable.alexander_isak,
            isPlayerLeft = false
        ),
        Player(
            name = "Mohamed Salah",
            marketPrice = 65,
            equipo = Teams.LIV,
            pic = R.drawable.mo_salah,
            isPlayerLeft = false
        ),
        Player(
            name = "Rasmus HØljund",
            marketPrice = 65,
            equipo = Teams.MUN,
            pic = R.drawable.mo_salah,
            isPlayerLeft = false
        ),
        Player(
            name = "Alexis Mac Allister",
            marketPrice = 65,
            equipo = Teams.LIV,
            pic = R.drawable.macalister
        ),
        Player(
            name = "Mason Mount",
            marketPrice = 60,
            equipo = Teams.MUN,
            pic = R.drawable.mason_mount
        ),
        Player(
            name = "Julián Álvarez",
            marketPrice = 80,
            equipo = Teams.MCI,
            pic = R.drawable.julian_alvarez
        ),
        Player(
            name = "Antony",
            marketPrice = 50,
            equipo = Teams.MUN,
            pic = R.drawable.antony,
            isPlayerLeft = false
        ),
        Player(
            name = "James Maddison",
            marketPrice = 70,
            equipo = Teams.TOT,
            pic = R.drawable.maddison
        ),
        Player(
            name = "Brenan Jhonson",
            marketPrice = 48,
            equipo = Teams.TOT,
            pic = R.drawable.maddison
        ),
        Player(
            name = "Cristian Romero",
            marketPrice = 60,
            equipo = Teams.TOT,
            pic = R.drawable.maddison
        ),
        Player(
            name = "Raheem Sterling",
            marketPrice = 50,
            equipo = Teams.CHE,
            pic = R.drawable.raheem_sterling
        ),
        Player(
            name = "Kai Havertz",
            marketPrice = 60,
            equipo = Teams.ARS,
            pic = R.drawable.kai_havertz,
            isPlayerLeft = false
        ),
        Player(
            name = "Sandro Tonali",
            marketPrice = 60,
            equipo = Teams.NEW,
            pic = R.drawable.sandro_tonali
        ),
        Player(
            name = "Jeremy Doku",
            marketPrice = 60,
            equipo = Teams.MCI,
            pic = R.drawable.doku
        ),
        Player(
            name = "Diogo Jota",
            marketPrice = 50,
            equipo = Teams.LIV
        ),
        Player(
            name = "Lisandro Martínez",
            marketPrice = 50,
            equipo = Teams.MUN,
            pic = R.drawable.licha
        ),
        Player(
            name = "Richarlison",
            marketPrice = 40,
            equipo = Teams.NEW,
            pic = R.drawable.richarlison,
            isPlayerLeft = false
        ),
        Player(
            name = "Mikhaylo Mudryk",
            marketPrice = 45,
            equipo = Teams.CHE,
            pic = R.drawable.mudryk,
            isPlayerLeft = false
        ),
        Player(
            name = "Matheus Nunes",
            marketPrice = 45,
            equipo = Teams.MCI,
            pic = R.drawable.nunes_matheus,
            isPlayerLeft = false
        ),
        Player(
            name = "Jadon Sancho",
            marketPrice = 32,
            equipo = Teams.MUN,
            pic = R.drawable.jadon_sancho,
            isPlayerLeft = false
        ),
        Player(
            name = "Pierre-Emile Höjbjerg",
            marketPrice = 45,
            equipo = Teams.TOT,
            pic = R.drawable.holberj,
            isPlayerLeft = false
        ),
        Player(
            name = "Lucas Paquetá",
            marketPrice = 45,
            equipo = Teams.WHU,
            pic = R.drawable.paqueta,
            isPlayerLeft = false
        ),
        Player(
            name = "Sven Botman",
            marketPrice = 45,
            equipo = Teams.NEW,
            pic = R.drawable.sven_botman
        ),
        Player(
            name = "Amadou Onana",
            marketPrice = 50,
            equipo = Teams.EVE,
            pic = R.drawable.amadou_onana,
            isPlayerLeft = false
        ),
        Player(
            name = "Luke Shaw",
            marketPrice = 42,
            equipo = Teams.MUN,
            pic = R.drawable.luke_shaw,
            isPlayerLeft = false
        ),
        Player(
            name = "Ryan Gravenberch",
            marketPrice = 35,
            equipo = Teams.LIV,
            pic = R.drawable.gravenberch
        ),
        Player(
            name = "Joelinton",
            marketPrice = 42,
            equipo = Teams.NEW,
            pic = R.drawable.joelinton
        ),
        Player(
            name = "Oleksandr Zinchenko",
            marketPrice = 42,
            equipo = Teams.ARS,
            pic = R.drawable.zinchenko
        ),
        Player(
            name = "Nathan Aké",
            marketPrice = 42,
            equipo = Teams.MCI,
            pic = R.drawable.nathan_ake,
            isPlayerLeft = false
        ),
        Player(
            name = "Jacob Ramsey",
            marketPrice = 42,
            equipo = Teams.AVL,
            pic = R.drawable.jacon_ramsey
        ),
        Player(
            name = "Benoit Badiashile",
            marketPrice = 40,
            equipo = Teams.CHE,
            pic = R.drawable.badiashile
        ),
        Player(
            name = "Nicolas Jackson",
            marketPrice = 35,
            equipo = Teams.CHE,
            pic = R.drawable.nicolas_jackson,
            isPlayerLeft = false
        ),
        Player(
            name = "Eberechi Eze",
            marketPrice = 48,
            equipo = Teams.CRY,
            pic = R.drawable.eberechi_eze
        ),
        Player(
            name = "Diogo Dalot",
            marketPrice = 40,
            equipo = Teams.MUN,
            pic = R.drawable.diogo_dalot
        ),
        Player(
            name = "John Stones",
            marketPrice = 40,
            equipo = Teams.MCI,
            pic = R.drawable.john_stones
        ),
        Player(
            name = "Ederson",
            marketPrice = 40,
            equipo = Teams.MCI,
            pic = R.drawable.ederson,
            isPlayerLeft = false
        ),
        Player(
            name = "Aaron Ramsdale",
            marketPrice = 40,
            equipo = Teams.ARS,
            pic = R.drawable.ramsdale
        ),
        Player(
            name = "Douglas Luiz",
            marketPrice = 40,
            equipo = Teams.AVL,
            pic = R.drawable.douglas_luiz
        ),
        Player(
            name = "Morgan Gibbs-White",
            marketPrice = 40,
            equipo = Teams.NFO,
            pic = R.drawable.morgan_gibbs
        ),
        Player(
            name = "Pedro Porro",
            marketPrice = 40,
            equipo = Teams.NFO,
            pic = R.drawable.pedro_porro
        ),
        Player(
            name = "Rodrigo Betancur",
            marketPrice = 40,
            equipo = Teams.TOT,
            pic = R.drawable.betancur
        ),
        Player(
            name = "Joao Palhinha",
            marketPrice = 55,
            equipo = Teams.FUL,
            pic = R.drawable.palinha
        ),
        Player(
            name = "Manuel Akanji",
            marketPrice = 38,
            equipo = Teams.MCI,
            pic = R.drawable.akanji
        ),
        Player(
            name = "Ansu Fati",
            marketPrice = 40,
            equipo = Teams.BHA,
            pic = R.drawable.ansu_fati
        ),
        Player(
            name = "Edson Álvarez",
            marketPrice = 40,
            equipo = Teams.WHU,
            pic = R.drawable.edson_alvarez
        ),
        Player(
            name = "Mohammed Kudus",
            marketPrice = 40,
            equipo = Teams.WHU,
            pic = R.drawable.kudus
        ),
        Player(
            name = "Raúl Jiménez",
            marketPrice = 40,
            equipo = Teams.FUL,
            pic = R.drawable.raul_jimenez,
            isPlayerLeft = false
        ),
        Player(
            name = "Destiny Udogie",
            marketPrice = 38,
            equipo = Teams.TOT,
            pic = R.drawable.udogie,
            isPlayerLeft = false
        ),
        Player(
            name = "Joe Willock",
            marketPrice = 38,
            equipo = Teams.NEW,
            pic = R.drawable.joe_willock,
            isPlayerLeft = false
        ),
        Player(
            name = "Thomas Partey",
            marketPrice = 38,
            equipo = Teams.ARS,
            pic = R.drawable.partey,
            isPlayerLeft = false
        ),
        Player(
            name = "Virjil Van Dijk",
            marketPrice = 35,
            equipo = Teams.LIV,
            pic = R.drawable.van_dijk
        ),
        Player(
            name = "Leandro Trossard",
            marketPrice = 35,
            equipo = Teams.ARS,
            pic = R.drawable.trossard,
            isPlayerLeft = false
        ),
        Player(
            name = "Sofyan Amrabat",
            marketPrice = 30,
            equipo = Teams.MUN,
            pic = R.drawable.amrabat,
            isPlayerLeft = false
        ),
        Player(
            name = "Eddie Nketiah",
            marketPrice = 30,
            equipo = Teams.ARS,
            pic = R.drawable.nketiah,
            isPlayerLeft = false
        ),
        Player(
            name = "Armando Broja",
            marketPrice = 28,
            equipo = Teams.CHE,
            pic = R.drawable.broja
        ),
        Player(
            name = "Emiliano Martínez",
            marketPrice = 28,
            equipo = Teams.AVL,
            pic = R.drawable.dibu
        ),
        Player(
            name = "Takehiro Tomiyasu",
            marketPrice = 25,
            equipo = Teams.ARS,
            pic = R.drawable.tomiyasu,
            isPlayerLeft = false
        ),
        Player(
            name = "Guglielmo Vicario",
            marketPrice = 20,
            equipo = Teams.TOT,
            pic = R.drawable.vicario
        ),
        Player(
            name = "Rico Lewis",
            marketPrice = 20,
            equipo = Teams.MCI,
            pic = R.drawable.rico_lewis
        ),
        Player(
            name = "Dwight McNeil",
            marketPrice = 20,
            equipo = Teams.EVE,
            pic = R.drawable.dwight,
            isPlayerLeft = false
        ),
        Player(
            name = "Anthony Elanga",
            marketPrice = 18,
            equipo = Teams.NFO,
            pic = R.drawable.elanga
        ),
        Player(
            name = "Jhon Duran",
            marketPrice = 17,
            equipo = Teams.AVL,
            pic = R.drawable.jhon_duran
        ),
        Player(
            name = "Timothy Castagne",
            marketPrice = 17,
            equipo = Teams.AVL,
            pic = R.drawable.castagne
        )
    )

    //27
    private val europePlayers = listOf(
        Player(
            name = "Kylian Mbappé",
            marketPrice = 180,
            equipo = Teams.PSG,
            pic =  R.drawable.kylian_mbappe
        ),Player(
            name = "Jude Bellingham",
            marketPrice = 150,
            equipo = Teams.RMA,
            pic =  R.drawable.jude_bellingham
        ),Player(
            name = "Vinicius Junior",
            marketPrice = 150,
            equipo = Teams.RMA,
            pic =  R.drawable.vini,
            isPlayerLeft = false
        ),Player(
            name = "Victor Osimhen",
            marketPrice = 120,
            equipo = Teams.NAP,
            pic =  R.drawable.osimhen
        ),Player(
            name = "Jamal Musiala",
            marketPrice = 150,
            equipo = Teams.BYM,
            pic =  R.drawable.musiala
        ),Player(
            name = "Pedri",
            marketPrice = 100,
            equipo = Teams.FCB,
            pic =  R.drawable.pedri
        ),Player(
            name = "Rodrygo Goes",
            marketPrice = 100,
            equipo = Teams.RMA,
            pic =  R.drawable.rodrygo
        ),Player(
            name = "Lautaro Martínez",
            marketPrice = 100,
            equipo = Teams.INT,
            pic =  R.drawable.lautaro,
            isPlayerLeft = false
        ),Player(
            name = "Federico Valverde",
            marketPrice = 100,
            equipo = Teams.RMA,
            pic =  R.drawable.fede_valverde
        ),Player(
            name = "Gavi",
            marketPrice = 90,
            equipo = Teams.FCB,
            pic =  R.drawable.gavi,
            isPlayerLeft = false
        ),Player(
            name = "Leroy Sané",
            marketPrice = 75,
            equipo = Teams.BYM,
            pic =  R.drawable.leroy_sane
        ),Player(
            name = "Ronald Araújo",
            marketPrice = 70,
            equipo = Teams.FCB,
            pic =  R.drawable.araujo
        ),Player(
            name = "Khvicha Kvaratskhelia",
            marketPrice = 85,
            equipo = Teams.NAP,
            pic =  R.drawable.kvicha,
            isPlayerLeft = false
        ),Player(
            name = "Raphael Leao",
            marketPrice = 90,
            equipo = Teams.MIL,
            pic =  R.drawable.leao
        ),Player(
            name = "Aurelien Tchouameni",
            marketPrice = 90,
            equipo = Teams.RMA,
            pic =  R.drawable.tchouameni
        ),Player(
            name = "Eduardo Camavinga",
            marketPrice = 90,
            equipo = Teams.RMA,
            pic =  R.drawable.camavinga
        ),Player(
            name = "Kolo Muani",
            marketPrice = 80,
            equipo = Teams.PSG,
            pic =  R.drawable.kolo_muani,
            isPlayerLeft = false
        ),Player(
            name = "Nicolo Barella",
            marketPrice = 80,
            equipo = Teams.PSG,
            pic =  R.drawable.barella,
            isPlayerLeft = false
        ),Player(
            name = "Dusan Vhalovic",
            marketPrice = 80,
            equipo = Teams.PSG,
            pic =  R.drawable.vhalovic,
            isPlayerLeft = false
        ),Player(
            name = "Achraf Hakimi",
            marketPrice = 65,
            equipo = Teams.PSG,
            pic =  R.drawable.hakimi,
            isPlayerLeft = false
        ),Player(
            name = "Kingsley Coman",
            marketPrice = 65,
            equipo = Teams.PSG,
            pic =  R.drawable.coman,
            isPlayerLeft = false
        ),Player(
            name = "Marquinhos",
            marketPrice = 65,
            equipo = Teams.PSG,
            pic =  R.drawable.marquinos
        ),Player(
            name = "Jonathan David",
            marketPrice = 60,
            equipo = Teams.PSG,
            pic =  R.drawable.jonatan_david
        ),Player(
            name = "Alessandro Bastoni",
            marketPrice = 60,
            equipo = Teams.INT,
            pic =  R.drawable.bastoni,
            isPlayerLeft = false
        ),Player(
            name = "Santiago Giménez",
            marketPrice = 40,
            equipo = Teams.FEY,
            pic =  R.drawable.santi_gimenez
        ),Player(
            name = "Xavi Simons",
            marketPrice = 70,
            equipo = Teams.PSG,
            pic =  R.drawable.simons
        ),Player(
            name = "Warren Zaire-Emery",
            marketPrice = 50,
            equipo = Teams.PSG,
            pic =  R.drawable.zaire_emery
        ),
    )
}