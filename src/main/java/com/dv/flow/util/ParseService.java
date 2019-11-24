package com.dv.flow.util;

import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Optional;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

@Slf4j
@Service
public class ParseService {
    public Optional<String> parseFile(MultipartFile file) {
        log.info("Parsing multipart file: {}", file.getOriginalFilename());
        Optional<String> result = Optional.empty();
        try {
            String rrr = Strings.EMPTY;
            ZipFile zipFile = convertFile(file);
            Enumeration e = zipFile.entries();
            while (e.hasMoreElements()) {
                ZipEntry entry = (ZipEntry) e.nextElement();
                rrr += "*" + entry.getName();
            }
            result = Optional.of(rrr);

            //TODO get list of path

            //TODO list to map

            //TODO ...
        } catch (IOException ioe) {
            System.out.println("Error opening zip file" + ioe);
        }
        return result;
    }

    private ZipFile convertFile(MultipartFile file) throws IOException {
        log.info("Converting multipart file to zipfile: {}", file.getOriginalFilename());
        ZipInputStream zipInputStream = new ZipInputStream(file.getInputStream());
        //TODO ZipFile zipFile = ;
        return new ZipFile("...");
    }
}
