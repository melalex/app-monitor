package com.appmonitor.webservice.constraints.validators;

import com.appmonitor.webservice.constraints.File;
import com.google.common.collect.Lists;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class FileValidator implements ConstraintValidator<File, MultipartFile> {
    private long maxSize;
    private List<String> types;

    @Override
    public void initialize(File constraint) {
        maxSize = constraint.maxSize();
        types = Lists.newArrayList(constraint.types());
    }

    @Override
    public boolean isValid(MultipartFile obj, ConstraintValidatorContext context) {
        return isValidSize(obj) && isValidType(obj);
    }

    private boolean isValidSize(MultipartFile obj) {
        return maxSize <= 0 || maxSize >= obj.getSize();
    }

    private boolean isValidType(MultipartFile obj) {
        return !CollectionUtils.isNotEmpty(types)
                || types.stream().anyMatch(t -> obj.getContentType().matches(t));
    }
}
