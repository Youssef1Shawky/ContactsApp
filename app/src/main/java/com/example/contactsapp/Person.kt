package com.example.contactsapp

class Person(
    val picture: Int,
    val name: String,
    val phoneNo: String
)

class DataSource{
    fun getData():List<Person>{
        var persons = mutableListOf<Person>()

        persons.add(Person(R.drawable.auntie ,"Auntie" ,"+201012345678" ))
        persons.add(Person(R.drawable.brother ,"Brother" ,"+201123456789" ))
        persons.add(Person(R.drawable.daughter ,"Daughter" ,"+201234567890" ))

        persons.add(Person(R.drawable.friend_1 ,"Friend 1 " ,"+20134567890" ))
        persons.add(Person(R.drawable.friend_2 ,"Friend 2 " ,"+201456789012" ))
        persons.add(Person(R.drawable.grandfather ,"Grandfather" ,"+201567890123" ))


        persons.add(Person(R.drawable.granny ,"Granny" ,"+201678901234" ))
        persons.add(Person(R.drawable.neigbour ,"Neighbour" ,"+201789012345" ))
        persons.add(Person(R.drawable.sister ,"Sister" ,"+201890123456" ))
        persons.add(Person(R.drawable.son ,"Son" ,"+201890123465" ))
        persons.add(Person(R.drawable.uncle ,"Uncle" ,"+201890123654" ))




        return persons
    }
}