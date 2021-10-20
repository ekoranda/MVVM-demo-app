package com.koranda.mypets.data.repository.model

 class Pet{
     var name: String? = null
      var type: String? = null
      var image: String? = null

     constructor(){}

     constructor(
         name:String?,
         type: String?,
        image: String?
     ){
         this.name = name
         this.type = type
         this.image = image
     }



 }


