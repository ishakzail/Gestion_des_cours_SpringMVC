package com.este.service;

import java.util.List;
import java.util.Optional;

import org.springframework.web.multipart.MultipartFile;

import com.este.models.Fichier;

public interface FichierService {

	public Fichier save(Fichier fichier);
	
	public void delete(int id);

	
	public Iterable<Fichier> getFichiers();
}
