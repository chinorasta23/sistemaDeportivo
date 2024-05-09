
package com.sistemaDeportivo.service;

import org.springframework.web.multipart.MultipartFile;


public interface FirebaseStorageService {
    
    public String cargaImagen(MultipartFile archivoLocalCliente, String carpeta, Long id);

    final String BucketName = "prueba1-60d73.appspot.com";

    final String rutaSuperiorStorage = "prueba_i";

    final String rutaJsonFile = "firebase";

    final String archivoJsonFile = "prueba1-60d73-firebase-adminsdk-izrsc-baf21657d5.json";
    
}
