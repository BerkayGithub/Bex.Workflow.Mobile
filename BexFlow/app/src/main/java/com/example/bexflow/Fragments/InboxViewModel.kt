package com.example.bexflow.Fragments

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.bexflow.`object`.Message
import androidx.lifecycle.MutableLiveData

class InboxViewModel : ViewModel() {

    private val messages: MutableLiveData<List<Message>> by lazy {
        MutableLiveData<List<Message>>().also {
            //loadMessages()
        }
    }

    fun getMessages(): LiveData<List<Message>> {
        return messages
    }

    private fun loadMessages() {
        //Do operation to fetch the messages.
        val s1 = arrayOf<String>("Can","Burak","Berkay","Hande","Kaya","Emre")
        val s2 = arrayOf<String>("Uzaktan Eğitim","Random Subject","Random Subject","Random Subject","Random Subject","Random Subject")
        val s3 = arrayOf<String>(
            "Değerli Öğrencilerimiz,\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "Uzaktan Eğitim sürecinde sınav güvenliğinin sağlanması amacıyla sınavlarda Respondus LockDown Browser ve Respondus Monitor aracı kullanılacaktır. LockDown Browser, sınav başlatıldığında sınav ekranının tam ekran olmasını sağlar ve diğer uygulama ve dosyalara erişiminizi engeller. Monitor aracı ise bilgisayarınızın kamera ve mikrofonunu kullanarak yüzünüzün, kimlik kartınızın, bulunduğunuz ortamın görüntülenip kaydedilmesini sağlar. Araçların kullanım kılavuzları ekte sunulmuştur. Lütfen kılavuzları inceleyiniz ve kullanım videolarını izleyiniz.\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "Sınavlarınızda başarılar dileriz.",
            "This is a random message.",
            "This is a random message.",
            "This is a random message.",
            "This is a random message.",
            "This is a random message."
        )
        for(x in 0 until s1.size){
            var msgToAdd = Message(s1[x], s2[x], s3[x])
        }

    }
}
