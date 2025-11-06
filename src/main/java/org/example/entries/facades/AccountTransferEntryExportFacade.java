package org.example.entries.facades;

import com.google.gson.Gson;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import org.example.accounts.services.AccountStorageService;
import org.example.entries.AccountTransferEntry;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@Singleton
public class AccountTransferEntryExportFacade {

    @Inject
    private AccountStorageService accountStorageService;

    @Inject
    private Gson gson;

    public void writeAllEntries(){
        accountStorageService.getAllBankAccounts().forEach(account -> {

            List<AccountTransferEntry> toExport = account.getAccountTransferEntries().stream()
                    .filter(entry -> !entry.isWasExported())
                    .toList();

            try(FileWriter fileWriter = new FileWriter(account.getUuid() + "_" + LocalDate.now() + ".json")){
                gson.toJson(toExport, fileWriter);
                toExport.forEach(entry -> entry.setWasExported(true));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }

}
