package com.spy.wb.aihotel_new.data;

/**
 * Copyright (C) 2015 Ari C.
 * <p/>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p/>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p/>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import android.content.Context;
import android.widget.Filter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.spy.wb.aihotel_new.model.RecordModel;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RecordDataHelper {

    private static final String RECORD_FILE_NAME = "records.json";

    private static List<RecordModel> sRecordModels = new ArrayList<>();

    public interface OnFindRecordsListener {
        void onResults(List<RecordModel> results);
    }

    public static void findTodayRecords(Context context, Date date, final OnFindRecordsListener listener) {
        SimpleDateFormat f = new SimpleDateFormat("yyyy年MM月dd日");
        findRecords(context, f.format(new Date()).toString(),listener);
    }

    public static void findRecords(Context context, String query, final OnFindRecordsListener listener) {
        initRecordModelList(context);

        new Filter() {

            @Override
            protected FilterResults performFiltering(CharSequence constraint) {


                List<RecordModel> suggestionList = new ArrayList<>();

                if (!(constraint == null || constraint.length() == 0)) {

                    for (RecordModel record : sRecordModels) {
                        if (record.getName().toUpperCase()
                                .startsWith(constraint.toString().toUpperCase())) {

                            suggestionList.add(record);
                        }
                    }

                }

                FilterResults results = new FilterResults();
                results.values = suggestionList;
                results.count = suggestionList.size();

                return results;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {

                if (listener != null) {
                    listener.onResults((List<RecordModel>) results.values);
                }
            }
        }.filter(query);

    }

    private static void initRecordModelList(Context context) {

        if (sRecordModels.isEmpty()) {
            String jsonString = loadJson(context);
            sRecordModels = deserializeColors(jsonString);
        }
    }

    private static String loadJson(Context context) {

        String jsonString;

        try {
            InputStream is = context.getAssets().open(RECORD_FILE_NAME);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            jsonString = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }

        return jsonString;
    }

    private static List<RecordModel> deserializeColors(String jsonString) {

        Gson gson = new GsonBuilder().setDateFormat("yyyy年MM月dd日 HH:mm:ss").create();

        Type collectionType = new TypeToken<List<RecordModel>>() {
        }.getType();
        return gson.fromJson(jsonString, collectionType);
    }
}