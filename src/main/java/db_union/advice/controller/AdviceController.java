package db_union.advice.controller;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import db_union.advice.dao.AdviceMapper;
import db_union.advice.model.Advice;
import db_union.advice.model.AdviceWithReply;
import db_union.advice.service.IAdvicePassService;
import db_union.advice.service.IAdviceService;
import db_union.committee.model.Committee;
import db_union.committee.service.ICommitteeService;
import db_union.department.model.Department;
import db_union.department.service.IDepartmentService;
import db_union.reply.model.Reply;
import db_union.reply.service.IReplyService;
import db_union.utils.WordUtil;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import db_union.utils.Page;
import db_union.utils.PageUtil;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@CrossOrigin
@Controller
@RequestMapping("/adviceController")
public class AdviceController {

	private IAdviceService adviceservice;

	@Autowired
	public void setAdviceservice(IAdviceService adviceservice) {
		this.adviceservice = adviceservice;
	}

	private IAdvicePassService advicepassservice;

	@Autowired
	public void setAdvicepassservice(IAdvicePassService advicepassservice) {
		this.advicepassservice = advicepassservice;
	}

	private IReplyService replyservice;

	@Autowired
	public void setReplyservice(IReplyService replyservice) {
		this.replyservice = replyservice;
	}

	private IDepartmentService iDepartmentService;

	@Autowired
	public void setiDepartmentService(IDepartmentService iDepartmentService) {
		this.iDepartmentService = iDepartmentService;
	}

	private AdviceMapper advicemapper;

	@Autowired
	@SuppressWarnings("SpringJavaAutowiringInspection")
	public void setAdvicemapper(AdviceMapper advicemapper) {
		this.advicemapper = advicemapper;
	}

	private ICommitteeService committeeservice;

	@Autowired
	public void setCommitteeservice(ICommitteeService committeeservice) {
		this.committeeservice = committeeservice;
	}

	@RequestMapping(value = "/insertAdvice", method = RequestMethod.POST)
	public @ResponseBody
	HashMap<String, Integer> insertAdvice(Advice advice) {
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		if (advice == null) {
			System.out.println("advice:null");
		}
		boolean flag = adviceservice.insertAdvice(advice);
		if (flag) {
			map.put("FLAG", 1);
		} else {
			map.put("FLAG", 0);
		}
		return map;
	}

	@RequestMapping("/countAll")
	public @ResponseBody
	Integer countAllAdvice() {
		return adviceservice.countAllAdvice();
	}

	@RequestMapping("/showProcess")
	public @ResponseBody
	List<Advice> showProcess(String USERID) {
		return adviceservice.findAdviceByUserID(USERID);
	}

	@RequestMapping("/showAdvice")
	public @ResponseBody
	Advice showAdvice(Integer ADVICE_ID) {
		return adviceservice.findAdviceByID(ADVICE_ID);
	}

	@RequestMapping("/showPoiProcess")
	public @ResponseBody
	List<Object> showPoiProcess(Integer count) {
		Page page = PageUtil.createPage(10, adviceservice.countAllPoiAdvice(), count);
		List<Object> list = adviceservice.selectPoiAdviceByPage(page);
		list.add(page);
		return list;
	}

	@RequestMapping("/showadvicePassByPage")
	public @ResponseBody
	List<Object> showAdvicePassByPage(Integer COUNT) {
		Page page = PageUtil.createPage(10, adviceservice.countAllPassAdvice(), COUNT);
		List list = advicepassservice.findPassAdviceByPage(page);
		list.add(page);
		return list;
	}

	@RequestMapping("/showAdviceWithReplyByID")
	public @ResponseBody
	AdviceWithReply showAdviceWithReplyByID(Integer ADVICEID) {
		Advice advice = adviceservice.findAdviceByID(ADVICEID);
		Department department = iDepartmentService.findDepartmentByID(advice.getDepartmentId());
		List<Reply> list_reply = replyservice.selectByAdviceID(advice.getAdviceId());
		AdviceWithReply advicewithreply = new AdviceWithReply();
		BeanUtils.copyProperties(advice, advicewithreply);
		advicewithreply.setReply(list_reply);
		advicewithreply.setDepartmentName(department.getDepartmentName());
		return advicewithreply;
	}

	@RequestMapping("/showAdviceWithReplyByID2")
	public @ResponseBody
	Object showAdviceWithReplyByID2(Integer ADVICEID) {
		Advice advice = adviceservice.findAdviceByID(ADVICEID);
		if (advice.getAdviceState() != 1) {
			return 0;
		} else {
			Department department = iDepartmentService.findDepartmentByID(advice.getDepartmentId());
			List<Reply> list_reply = replyservice.selectByAdviceID(advice.getAdviceId());
			AdviceWithReply advicewithreply = new AdviceWithReply();
			BeanUtils.copyProperties(advice, advicewithreply);
			advicewithreply.setReply(list_reply);
			advicewithreply.setDepartmentName(department.getDepartmentName());
			return advicewithreply;
		}
	}

	@RequestMapping("/countUpdate")
	public @ResponseBody
	Integer countUpdate(Integer ADVICEID, Integer COUNT, String COMMITTEEID) {

		Committee c = committeeservice.findCommitteeByID(COMMITTEEID);

		String name = c.getCommitteeName();

		Advice a = adviceservice.findAdviceByID(ADVICEID);
		if (a.getCount() >= 2) {
			a.setAdviceState(-1);
			adviceservice.updateAdvicestate(a);
		}
		String agree = a.getAdviceAgree();
		agree = agree + " " + name;
		a.setAdviceAgree(agree);
		adviceservice.updateCountByPrimaryKeySelective(a);
		return adviceservice.adviceCount(ADVICEID, COUNT);

	}

	@RequestMapping("/adviceNumUpdate")
	public @ResponseBody
	Integer adviceNumUpdate(Integer ADVICEID, String NUM) {

		Advice a = new Advice();
		a.setAdviceId(ADVICEID);
		a.setAdviceNum(NUM);
		int count = adviceservice.updateByPrimaryKeySelective(a);
		return count;
	}

	@RequestMapping("/adviceDepartUpdate")
	public @ResponseBody
	Integer adviceDepartUpdate(Integer ADVICEID, String DEPRTMENTID) {
		Advice a = new Advice();
		a.setAdviceId(ADVICEID);
		a.setDepartmentId(DEPRTMENTID);
		int count = adviceservice.updateByPrimaryKeySelective(a);
		return count;
	}

	@RequestMapping("/findAdviceByCommitteeID")
	public @ResponseBody
	List<Object> findAdviceByCommitteeID(String COMMITTEEID, Integer COUNT) {
		Page page = PageUtil.createPage(10, adviceservice.countAllAdviceByCOMMITTEEID(COMMITTEEID), COUNT);
		HashMap<String, Object> hashmap = new HashMap();
		hashmap.put("id", COMMITTEEID);
		hashmap.put("begin", page.getBeginIndex());
		hashmap.put("every", page.getEveryPage());
		List<Object> list = adviceservice.findAdviceByCommitteeID(hashmap);
		list.add(page);
		return list;
	}

	@RequestMapping("/findAdviceByDepartmentID")
	public @ResponseBody
	List<Object> findAdviceByDepartmentID(String DEPRTMENTID, Integer COUNT) {
		Page page = PageUtil.createPage(10, adviceservice.countAllAdviceByDEPARTMENTID(DEPRTMENTID), COUNT);
		System.out.println(adviceservice.countAllAdviceByDEPARTMENTID(DEPRTMENTID));
		System.out.println(DEPRTMENTID);
		HashMap<String, Object> hashmap = new HashMap<String, Object>();
		hashmap.put("id", DEPRTMENTID);
		hashmap.put("begin", page.getBeginIndex());
		hashmap.put("every", page.getEveryPage());
		List<Object> list = adviceservice.findAdviceByDepartmentID(hashmap);
		list.add(page);
		return list;
	}

	@RequestMapping("/selectAdviceLike")
	public @ResponseBody
	List<Object> selectAdviceLike(String poi, Integer count) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		System.out.println(poi + "_" + count);
		Page page = PageUtil.createPage(10, adviceservice.countAllPassAdviceLike(poi), count);
		map.put("poi", poi);
		map.put("begin", page.getBeginIndex());
		map.put("every", page.getEveryPage());
		List list = adviceservice.selectAdviceLike(map);
		list.add(page);
		return list;
	}

	@RequestMapping("/updataAdviceStates")
	public @ResponseBody
	Integer updataAdviceStates(Integer adviceid, Integer stateid) {
		Advice advice = adviceservice.findAdviceByID(adviceid);
		advice.setAdviceState(stateid);
		int count = adviceservice.updateByPrimaryKeySelective(advice);
		return count;
	}

	@RequestMapping("/updataAdviceSH")
	public @ResponseBody
	Integer updataAdviceNum(Integer adviceid, String num, Integer stateid, String departid) {
		Advice advice = adviceservice.findAdviceByID(adviceid);
		advice.setAdviceNum(num);
		advice.setAdviceState(stateid);
		advice.setDepartmentId(departid);
		int count = adviceservice.updateByPrimaryKeySelective(advice);
		return count;
	}

	@RequestMapping("/selectAdviceN0N2")
	public @ResponseBody
	Advice selectAdviceN0N2(Integer id) {
		return adviceservice.selectAdviceN0N2(id);
	}

	@RequestMapping("/selectCountB2")
	public @ResponseBody
	List<Object> selectCountB2(Integer count) {
		Page page = PageUtil.createPage(10, adviceservice.countAllCountB2(), count);
		List list = adviceservice.selectCountB2(page);
		list.add(page);
		return list;
	}

	@RequestMapping("/selectAllPassAdvice")
	public List<Object> selectAllPassAdvice(Integer count) {
		Page page = PageUtil.createPage(10, adviceservice.countAllPassAdvice(), count);
		List list = adviceservice.selectAllPassAdvice(page);
		list.add(page);
		return list;
	}

	@RequestMapping("/countAllState")
	public @ResponseBody
	Integer countAllState(Integer stateid) {
		return adviceservice.countAllState(stateid);
	}

	@RequestMapping("/findAdviceDSH")
	public @ResponseBody
	List findAdviceDSH(Integer count) {
		Page page = PageUtil.createPage(10, adviceservice.countAllState(-1), count);
		List list = adviceservice.findAdviceByStateF1(page);
		list.add(page);
		return list;
	}

	/*@RequestMapping(value = "/export", method = RequestMethod.GET)
	public void exportXxx(HttpServletResponse response, Integer ADVICEID)
			throws IOException {
		Advice advice = adviceservice.findAdviceByID(ADVICEID);
		Department department = iDepartmentService.findDepartmentByID(advice.getDepartmentId());
		List<Reply> list_reply = replyservice.selectByAdviceID(advice.getAdviceId());
		AdviceWithReply advicewithreply = new AdviceWithReply();
		BeanUtils.copyProperties(advice, advicewithreply);
		advicewithreply.setReply(list_reply);
		advicewithreply.setDepartmentName(department.getDepartmentName());

		//第一步，创建一个webbook，对应一个excel文件
		HSSFWorkbook hk = new HSSFWorkbook();
		//第二步，在webbook中添加一个sheet，对应excel中的sheet
		HSSFSheet sheet = hk.createSheet(new String("测试".getBytes(), "utf-8"));
		//创建sheet标题行
		HSSFRow row = sheet.createRow(0);
		HSSFCell cellTitle = row.createCell(0);
		//设置标题
		sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 5));
		cellTitle.setCellValue(advicewithreply.getAdviceTitle());
		//设置EXCEL其他内容

		HSSFRow row1 = sheet.createRow(1);

		HSSFCell cell_1_1 = row1.createCell(0);
		cell_1_1.setCellValue("提案标题");
		HSSFCell cell_1_2 = row1.createCell(1);
		sheet.addMergedRegion(new CellRangeAddress(1, 1, 1, 5));
		cell_1_2.setCellValue(advicewithreply.getTitle());

		HSSFRow row2 = sheet.createRow(2);

		HSSFCell cell_2_1 = row2.createCell(0);
		cell_2_1.setCellValue("提案人姓名");
		HSSFCell cell_2_2 = row2.createCell(1);
		cell_2_2.setCellValue(advicewithreply.getAdviceName());
		HSSFCell cell_2_3 = row2.createCell(2);
		cell_2_3.setCellValue("所在单位");
		HSSFCell cell_2_4 = row2.createCell(3);
		cell_2_4.setCellValue(advicewithreply.getAdviceWorkspace());
		HSSFCell cell_2_5 = row2.createCell(4);
		cell_2_5.setCellValue("联系方式");
		HSSFCell cell_2_6 = row2.createCell(5);
		cell_2_6.setCellValue(advicewithreply.getContactway());

		HSSFRow row3 = sheet.createRow(3);
		HSSFCell cell_3_1 = row3.createCell(0);
		cell_3_1.setCellValue("附议人姓名");
		HSSFCell cell_3_2 = row3.createCell(1);
		sheet.addMergedRegion(new CellRangeAddress(3, 3, 1, 5));
		cell_3_2.setCellValue(advicewithreply.getAdviceAgree());

		HSSFRow row4 = sheet.createRow(4);
		HSSFCell cell_4_1 = row4.createCell(0);
		cell_4_1.setCellValue("提案内容");
		HSSFCell cell_4_2 = row4.createCell(1);
		sheet.addMergedRegion(new CellRangeAddress(4, 4, 1, 5));
		cell_4_2.setCellValue(advicewithreply.getAdviceContent());

		HSSFRow row5 = sheet.createRow(5);
		HSSFCell cell_5_1 = row5.createCell(0);
		cell_5_1.setCellValue("建议措施");
		HSSFCell cell_5_2 = row5.createCell(1);
		sheet.addMergedRegion(new CellRangeAddress(5, 5, 1, 5));
		cell_5_2.setCellValue(advicewithreply.getAdviceDo());

		HSSFRow row6 = sheet.createRow(6);
		HSSFCell cell_6_1 = row6.createCell(0);
		cell_6_1.setCellValue("提案上报时间");
		HSSFCell cell_6_2 = row6.createCell(1);
		sheet.addMergedRegion(new CellRangeAddress(6, 6, 1, 5));
		DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		String date = sdf.format(advicewithreply.getAdviceTime());
		cell_6_2.setCellValue(date);

		HSSFRow row7 = sheet.createRow(7);
		HSSFCell cell_7_1 = row7.createCell(0);
		cell_7_1.setCellValue("提案处理部门");
		HSSFCell cell_7_2 = row7.createCell(1);
		sheet.addMergedRegion(new CellRangeAddress(7, 7, 1, 5));
		cell_7_2.setCellValue(advicewithreply.getDepartmentName());

		HSSFRow row8 = sheet.createRow(8);
		HSSFCell cell_8_1 = row8.createCell(0);
		cell_8_1.setCellValue("部门回复处理意见");
		HSSFCell cell_8_2 = row8.createCell(1);
		sheet.addMergedRegion(new CellRangeAddress(8, 8, 1, 5));
		cell_8_2.setCellValue(advicewithreply.getReply().get(0).getReplyContent());

		HSSFRow row9 = sheet.createRow(9);
		HSSFCell cell_9_1 = row9.createCell(0);
		cell_9_1.setCellValue("领导回复处理意见");
		HSSFCell cell_9_2 = row9.createCell(1);
		sheet.addMergedRegion(new CellRangeAddress(9, 9, 1, 5));
		List reply = advicewithreply.getReply();
		cell_9_2.setCellValue(advicewithreply.getReply().get(reply.size() - 1).getLeaderReply());

		HSSFRow row10 = sheet.createRow(10);
		HSSFCell cell_10_1 = row10.createCell(0);
		cell_10_1.setCellValue("提案人是否满意");
		HSSFCell cell_10_2 = row10.createCell(1);
		sheet.addMergedRegion(new CellRangeAddress(10, 10, 1, 5));
		String state = "不满意";
		if (advicewithreply.getAdviceState() == 2) {
			state = "满意";
		}
		cell_10_2.setCellValue(state);

		response.setHeader("Content-Disposition", "attachment; filename=advice.xls");
		response.setContentType("application/vnd.ms-excel; charset=utf8");
		OutputStream out = response.getOutputStream();
		hk.write(out);
		out.flush();
		out.close();
	}*/

	/*@RequestMapping(value = "/exportWord", method = RequestMethod.GET)
	public void export(HttpServletResponse response, Integer ADVICEID)
			throws IOException {

		Advice advice = adviceservice.findAdviceByID(ADVICEID);
		Department department = iDepartmentService.findDepartmentByID(advice.getDepartmentId());
		List<Reply> list_reply = replyservice.selectByAdviceID(advice.getAdviceId());
		AdviceWithReply advicewithreply = new AdviceWithReply();
		BeanUtils.copyProperties(advice, advicewithreply);
		advicewithreply.setReply(list_reply);
		advicewithreply.setDepartmentName(department.getDepartmentName());

		HashMap<String, Object> map = new HashMap<>();
		map.put("advicetitle", advicewithreply.getAdviceTitle());
		map.put("title", advicewithreply.getTitle());
		map.put("workspace", advicewithreply.getAdviceWorkspace());
		map.put("contact", advicewithreply.getContactway());
		map.put("advicename", advicewithreply.getAdviceName());
		map.put("adviceagree", advicewithreply.getAdviceAgree());
		map.put("advicecontent", advicewithreply.getAdviceContent());
		map.put("advicedo", advicewithreply.getAdviceDo());
		DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		String date = sdf.format(advicewithreply.getAdviceTime());
		map.put("advicetime", date);
		map.put("departmentname", advicewithreply.getDepartmentName());
		map.put("replycontent", advicewithreply.getReply().get(0).getReplyContent());
		List reply = advicewithreply.getReply();
		map.put("leaderreply", advicewithreply.getReply().get(reply.size() - 1).getLeaderReply());
		String state = "不满意";
		if (advicewithreply.getAdviceState() == 2) {
			state = "满意";
		}
		map.put("state", state);
		DocumentHandler doc = new DocumentHandler();
		File file = doc.createDoc(map);
		InputStream fin = null;
		ServletOutputStream out = null;
		fin = new FileInputStream(file);
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/msword");
		// 设置浏览器以下载的方式处理该文件默认名为resume.doc
		response.addHeader("Content-Disposition", "attachment;filename=resume.doc");
		out = response.getOutputStream();
		byte[] buffer = new byte[512];  // 缓冲区
		int bytesToRead = -1;
		// 通过循环将读入的Word文件的内容输出到浏览器中
		while((bytesToRead = fin.read(buffer)) != -1) {
			out.write(buffer, 0, bytesToRead);
		}
	}*/
	@RequestMapping(value="export",method = RequestMethod.GET)
	public void exportWord(HttpServletResponse response,Integer ADVICEID) throws IOException {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String name = df.format(new Date());
		Advice advice = adviceservice.findAdviceByID(ADVICEID);
		Department department = iDepartmentService.findDepartmentByID(advice.getDepartmentId());
		List<Reply> list_reply = replyservice.selectByAdviceID(advice.getAdviceId());
		AdviceWithReply advicewithreply = new AdviceWithReply();
		BeanUtils.copyProperties(advice, advicewithreply);
		advicewithreply.setReply(list_reply);
		advicewithreply.setDepartmentName(department.getDepartmentName());

		HashMap<String, Object> dataMap = new HashMap<>();
		dataMap.put("title",advicewithreply.getTitle());
		dataMap.put("adviceName",advicewithreply.getAdviceName());
		dataMap.put("adviceWorkspace",advicewithreply.getAdviceWorkspace());
		dataMap.put("contactway",advicewithreply.getContactway());
		dataMap.put("adviceAgree",advicewithreply.getAdviceAgree());
		dataMap.put("adviceContent",advicewithreply.getAdviceContent());
		dataMap.put("adviceDo",advicewithreply.getAdviceDo());
		DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		String date  = sdf.format(advicewithreply.getAdviceTime());
		dataMap.put("adviceTime",date);
		dataMap.put("departmentName",advicewithreply.getDepartmentName());
		dataMap.put("replyContent",advicewithreply.getReply().get(0).getReplyContent());
		dataMap.put("leaderReply",advicewithreply.getReply().get(0).getLeaderReply());
		String state = "不满意";
		if(advicewithreply.getAdviceState() == 2){
			state = "满意";
		}
		dataMap.put("state",state);
		// 提示：在调用工具类生成Word文档之前应当检查所有字段是否完整
		// 否则Freemarker的模板殷勤在处理时可能会因为找不到值而报错 这里暂时忽略这个步骤了
		File file = null;
		InputStream fin = null;
		ServletOutputStream out = null;
		try {
			// 调用工具类WordGenerator的createDoc方法生成Word文档
			file = WordUtil.createDoc(dataMap, "model");
			fin = new FileInputStream(file);

			response.setCharacterEncoding("utf-8");
			response.setContentType("application/msword");
			// 设置浏览器以下载的方式处理该文件默认名为resume.doc
			response.addHeader("Content-Disposition", "attachment;filename="+name+".doc");

			out = response.getOutputStream();
			byte[] buffer = new byte[1024];  // 缓冲区
			int bytesToRead = -1;
			// 通过循环将读入的Word文件的内容输出到浏览器中
			while((bytesToRead = fin.read(buffer)) != -1) {
				out.write(buffer, 0, bytesToRead);
			}
		} finally {
			if(fin != null) fin.close();
			if(out != null) out.close();
			if(file != null) file.delete(); // 删除临时文件
		}
	}

}