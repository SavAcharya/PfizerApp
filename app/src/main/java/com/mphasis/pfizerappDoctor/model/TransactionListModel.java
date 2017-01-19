package com.mphasis.pfizerappDoctor.model;

import java.util.List;

/**
 * Created by Sourav.Bhattacharya on 1/18/2017.
 */

public class TransactionListModel {


    private List<TransactionsBean> transactions;

    public List<TransactionsBean> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<TransactionsBean> transactions) {
        this.transactions = transactions;
    }

    public static class TransactionsBean {
        /**
         * to : 1P3MJCpYvsYPa8MQchUZxfspY7195PJNry3JHc
         * from : 1STL3VKVt9nXE4gqHQf7s66HCrgsugFg7MhxMq
         * description : uploaded from cmd1
         * timestamp : Jan-17-2017 10:11:02
         * txid : 138ce130c580b579602cb540ba954f68013926e636b099b98941581f9b8350ad
         */

        private String to;
        private String from;
        private String description;
        private String timestamp;
        private String txid;

        public String getTo() {
            return to;
        }

        public void setTo(String to) {
            this.to = to;
        }

        public String getFrom() {
            return from;
        }

        public void setFrom(String from) {
            this.from = from;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getTimestamp() {
            return timestamp;
        }

        public void setTimestamp(String timestamp) {
            this.timestamp = timestamp;
        }

        public String getTxid() {
            return txid;
        }

        public void setTxid(String txid) {
            this.txid = txid;
        }
    }
}
