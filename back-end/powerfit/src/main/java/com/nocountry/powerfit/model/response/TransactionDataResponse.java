package com.nocountry.powerfit.model.response;

import com.amazonaws.services.dynamodbv2.xspec.S;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Builder
public class TransactionDataResponse {

    String collection_id;
   String collection_status;
   String payment_id;
   String status;
   String external_reference;
   String payment_type;
   String merchant_order_id;
   String preference_id;
   String site_id;
   String processing_mode;
   String merchant_account_id;
}
