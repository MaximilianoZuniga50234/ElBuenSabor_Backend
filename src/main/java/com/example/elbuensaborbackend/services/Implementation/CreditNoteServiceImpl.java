package com.example.elbuensaborbackend.services.Implementation;

import com.example.elbuensaborbackend.models.entities.CreditNote;
import com.example.elbuensaborbackend.repositories.BaseRepository;
import com.example.elbuensaborbackend.repositories.CreditNoteRepository;
import com.example.elbuensaborbackend.services.CreditNoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreditNoteServiceImpl extends BaseServiceImpl<CreditNote, Long> implements CreditNoteService {

    @Autowired
    private CreditNoteRepository creditNoteRepository;

    public CreditNoteServiceImpl(BaseRepository<CreditNote, Long> creditNoteRepository) {
        super(creditNoteRepository);
    }
}
