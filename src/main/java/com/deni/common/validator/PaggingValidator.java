package com.deni.common.validator;//package com.denpaden.springbootservice.unit.service.validator;

import com.deni.common.constants.Messages;
import com.deni.common.dto.PaggingRequestBodyDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PaggingValidator {


    public Validator requestValidator(PaggingRequestBodyDTO dto) {
        List<String> message = new ArrayList<>();

        if (dto.getPageNumber() == null) {
            message.add(String.format(Messages.MSG_FIELD_CANNOT_BE_NULL, "pageNumber"));
        }

        if (dto.getRowSize() == null) {
            message.add(String.format(Messages.MSG_FIELD_CANNOT_BE_NULL, "rowSize"));
        }

        if (dto.getSortBy() == null) {
            message.add(String.format(Messages.MSG_FIELD_CANNOT_BE_NULL, "sortBy"));
        }

        if (dto.getSortType() == null) {
            message.add(String.format(Messages.MSG_FIELD_CANNOT_BE_NULL, "sortType"));
        }


        if (message.isEmpty()) {
            return new Validator().yes();
        } else {
            String result = "";
            for (String str : message) {
                if (result.isEmpty()) {
                    result = str;
                } else {
                    result += ", " + str;
                }
            }
            return new Validator().no(result);
        }
    }
}
