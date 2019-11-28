package com.dzf.zxkj.platform.controller.icset;

import com.dzf.zxkj.common.entity.Json;
import com.dzf.zxkj.common.entity.ReturnData;
import com.dzf.zxkj.jackson.utils.JsonUtils;
import com.dzf.zxkj.platform.model.icset.InvAccSetVO;
import com.dzf.zxkj.platform.service.icset.IInvAccSetService;
import com.dzf.zxkj.platform.util.SystemUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/*
 * 库存入账设置
 */
@RestController
@RequestMapping("/icset/chkmszact")
@Slf4j
public class InvAccSetController {

	@Autowired
	private IInvAccSetService ic_chkmszserv = null;

	@GetMapping("/query")
	public ReturnData query() {
		Json json = new Json();
		InvAccSetVO vo = ic_chkmszserv.query(SystemUtil.getLoginCorpId());
		if(vo != null){
			json.setRows(vo);
			json.setSuccess(true);
			json.setMsg("查询成功");
		}else{
			json.setRows(null);
			json.setSuccess(false);
			json.setMsg("查询数据为空");
		}
		return ReturnData.ok().data(json);
	}

	@PostMapping("/save")
	public ReturnData save(@RequestBody Map<String, String> param) {
		Json json = new Json();
		InvAccSetVO data = JsonUtils.convertValue(param, InvAccSetVO.class);
		data.setPk_corp(SystemUtil.getLoginCorpId());
		InvAccSetVO vo = ic_chkmszserv.save(data);
		json.setRows(vo);
		json.setMsg("保存成功");
		json.setSuccess(true);
//		writeLogRecord(LogRecordEnum.OPE_KJ_IC_SET.getValue(), "库存入账设置", ISysConstants.SYS_2);
		return ReturnData.ok().data(json);
	}

	@GetMapping("/saveGroup")
	public ReturnData saveGroup() {
		Json json = new Json();
		InvAccSetVO vo = ic_chkmszserv.saveGroupVO(SystemUtil.getLoginCorpVo());
		json.setRows(vo);
		json.setMsg("获取入账科目成功");
		json.setSuccess(true);
//		writeLogRecord(LogRecordEnum.OPE_KJ_SALARY.getValue(), "库存入账设置获取入账科目", ISysConstants.SYS_2);
		return ReturnData.ok().data(json);
	}
}
