package com.minato.elasticsearch;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.minato.elasticsearch.model.Bandwidthd;
import com.minato.elasticsearch.repository.BandwidthdRepository;

@SpringBootApplication
public class SampleElasticsearchApplication implements CommandLineRunner {

	@Autowired
	private BandwidthdRepository bandwidthdRepository;

	@Override
	public void run(String... args) throws Exception {
		
		bandwidthdRepository.deleteAll();

		ArrayList<String> arrayList = new ArrayList<>();

		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");

		// int i = (int) bandwidthdRepository.count();

		try {

			File input = new File("C:/Users/Minato/Downloads/Bandwidthd.html");

			Document doc = Jsoup.parse(input, "UTF-8");

			Elements rows = doc.select("tr");

			for (Element row : rows) {

				Elements columns = row.select("td");

				arrayList.removeAll(arrayList);

				for (Element column : columns) {

					arrayList.add(column.text());

					String value = String.format("%15s", column.text());
					System.out.print(value);

				}
				System.out.println();

				Date presentTime = Calendar.getInstance().getTime();
				String reportDate = dateFormat.format(presentTime);

				saveBandwidthd(arrayList.get(0), arrayList.get(1), arrayList.get(2), arrayList.get(3), arrayList.get(4),
						arrayList.get(5), arrayList.get(6), arrayList.get(7), arrayList.get(8), arrayList.get(9),
						reportDate);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("Done get data!");
	}

	private void saveBandwidthd(String zero, String one, String two, String three, String four, String five, String six,
			String seven, String eight, String nine, String presentTime) {
		bandwidthdRepository
				.save(new Bandwidthd(zero, one, two, three, four, five, six, seven, eight, nine, presentTime));
	}

	public static void main(String[] args) {
		SpringApplication.run(SampleElasticsearchApplication.class, args);
	}

}