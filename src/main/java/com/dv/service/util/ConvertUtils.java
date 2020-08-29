package com.dv.service.util;

import com.dv.controller.data.resp.ResponseProjectInfo;
import com.dv.controller.data.resp.ResponseProjectTree;
import com.dv.db.model.Project;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ConvertUtils {

    public String getHash(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-1");
            byte[] messageDigest = md.digest(input.getBytes());
            BigInteger no = new BigInteger(1, messageDigest);
            String hashtext = no.toString(16);
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext;
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public List<ResponseProjectInfo> getProjectInfos(List<Project> projects) {
        List<ResponseProjectInfo> projectInfos = new ArrayList<>();
        projects.forEach(project -> projectInfos.add(new ResponseProjectInfo(project)));
        return projectInfos;
    }

    public ResponseProjectTree getProjectTree(Project project) {
        return new ResponseProjectTree(project);
    }
}
