<template>
<view class="content">
	<view :style='{"width":"100%","padding":"0","position":"relative","background":"#fff","height":"100%"}'>
		<form :style='{"width":"100%","padding":"24rpx","background":"#fff","display":"block","height":"auto"}' class="app-update-pv">
			<view :style='{"padding":"12rpx 0","margin":"0 0 24rpx 0","borderColor":"rgb(206, 206, 206)","alignItems":"center","borderWidth":"0 0 2rpx 0","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class="">
				<view :style='{"width":"160rpx","padding":"0 20rpx 0 0","lineHeight":"80rpx","fontSize":"28rpx","color":"#333","textAlign":"right"}' class="title">场馆名称</view>
				<input :style='{"border":"0","padding":"0px 20rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","flex":"1","background":"rgba(255, 255, 255, 0)","fontSize":"28rpx","height":"80rpx"}' :disabled="ro.changguanmingcheng" v-model="ruleForm.changguanmingcheng" placeholder="场馆名称"  type="text"></input>
			</view>
			<view :style='{"padding":"12rpx 0","margin":"0 0 24rpx 0","borderColor":"rgb(206, 206, 206)","alignItems":"center","borderWidth":"0 0 2rpx 0","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class=" select">
				<view :style='{"width":"160rpx","padding":"0 20rpx 0 0","lineHeight":"80rpx","fontSize":"28rpx","color":"#333","textAlign":"right"}' class="title">场馆类型</view>
				<picker :disabled="ro.changguanleixing" :style='{"width":"100%","flex":"1","height":"auto"}' @change="changguanleixingChange" :value="changguanleixingIndex" :range="changguanleixingOptions">
					<view :style='{"width":"100%","padding":"0 20rpx","lineHeight":"80rpx","fontSize":"28rpx","color":"#7C6047"}' class="uni-input">{{ruleForm.changguanleixing?ruleForm.changguanleixing:"请选择场馆类型"}}</view>
				</picker>
			</view>
			<view :style='{"padding":"12rpx 0","margin":"0 0 24rpx 0","borderColor":"rgb(206, 206, 206)","alignItems":"center","borderWidth":"0 0 2rpx 0","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class="" @tap="changguantupianTap">
				<view :style='{"width":"160rpx","padding":"0 20rpx 0 0","lineHeight":"80rpx","fontSize":"28rpx","color":"#333","textAlign":"right"}' class="title">场馆图片</view>
				<image :style='{"width":"80rpx","borderRadius":"100%","objectFit":"cover","display":"block","height":"80rpx"}' class="avator" v-if="ruleForm.changguantupian" :src="baseUrl+ruleForm.changguantupian.split(',')[0]" mode="aspectFill"></image>
				<image :style='{"width":"80rpx","borderRadius":"100%","objectFit":"cover","display":"block","height":"80rpx"}' class="avator" v-else src="../../static/gen/upload.png" mode="aspectFill"></image>
			</view>
			<view :style='{"padding":"12rpx 0","margin":"0 0 24rpx 0","borderColor":"rgb(206, 206, 206)","alignItems":"center","borderWidth":"0 0 2rpx 0","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class="">
				<view :style='{"width":"160rpx","padding":"0 20rpx 0 0","lineHeight":"80rpx","fontSize":"28rpx","color":"#333","textAlign":"right"}' class="title">场馆位置</view>
				<input :style='{"border":"0","padding":"0px 20rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","flex":"1","background":"rgba(255, 255, 255, 0)","fontSize":"28rpx","height":"80rpx"}' :disabled="ro.changguanweizhi" v-model="ruleForm.changguanweizhi" placeholder="场馆位置"  type="text"></input>
			</view>
			<view :style='{"padding":"12rpx 0","margin":"0 0 24rpx 0","borderColor":"rgb(206, 206, 206)","alignItems":"center","borderWidth":"0 0 2rpx 0","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class="">
				<view :style='{"width":"160rpx","padding":"0 20rpx 0 0","lineHeight":"80rpx","fontSize":"28rpx","color":"#333","textAlign":"right"}' class="title">场馆费用</view>
				<input :style='{"border":"0","padding":"0px 20rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","flex":"1","background":"rgba(255, 255, 255, 0)","fontSize":"28rpx","height":"80rpx"}' :disabled="ro.changguanfeiyong" v-model.number="ruleForm.changguanfeiyong" placeholder="场馆费用" type="number"></input>
			</view>
			<view :style='{"padding":"12rpx 0","margin":"0 0 24rpx 0","borderColor":"rgb(206, 206, 206)","alignItems":"center","borderWidth":"0 0 2rpx 0","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class=" select">
				<view :style='{"width":"160rpx","padding":"0 20rpx 0 0","lineHeight":"80rpx","fontSize":"28rpx","color":"#333","textAlign":"right"}' class="title">时间段</view>
				<picker :disabled="ro.shijianduan" :style='{"width":"100%","flex":"1","height":"auto"}' @change="shijianduanChange" :value="shijianduanIndex" :range="shijianduanOptions">
					<view :style='{"width":"100%","padding":"0 20rpx","lineHeight":"80rpx","fontSize":"28rpx","color":"#7C6047"}' class="uni-input">{{ruleForm.shijianduan?ruleForm.shijianduan:"请选择时间段"}}</view>
				</picker>
			</view>
			<view :style='{"padding":"12rpx 0","margin":"0 0 24rpx 0","borderColor":"rgb(206, 206, 206)","alignItems":"center","borderWidth":"0 0 2rpx 0","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class=" select">
				<view :style='{"width":"160rpx","padding":"0 20rpx 0 0","lineHeight":"80rpx","fontSize":"28rpx","color":"#333","textAlign":"right"}' class="title">场馆状态</view>
				<picker :disabled="ro.changguanzhuangtai" :style='{"width":"100%","flex":"1","height":"auto"}' @change="changguanzhuangtaiChange" :value="changguanzhuangtaiIndex" :range="changguanzhuangtaiOptions">
					<view :style='{"width":"100%","padding":"0 20rpx","lineHeight":"80rpx","fontSize":"28rpx","color":"#7C6047"}' class="uni-input">{{ruleForm.changguanzhuangtai?ruleForm.changguanzhuangtai:"请选择场馆状态"}}</view>
				</picker>
			</view>
			<view :style='{"padding":"12rpx 0","margin":"0 0 24rpx 0","borderColor":"rgb(206, 206, 206)","alignItems":"center","borderWidth":"0 0 2rpx 0","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class="">
				<view :style='{"width":"160rpx","padding":"0 20rpx 0 0","lineHeight":"80rpx","fontSize":"28rpx","color":"#333","textAlign":"right"}' class="title">管理账号</view>
				<input :style='{"border":"0","padding":"0px 20rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","flex":"1","background":"rgba(255, 255, 255, 0)","fontSize":"28rpx","height":"80rpx"}' :disabled="ro.guanlizhanghao" v-model="ruleForm.guanlizhanghao" placeholder="管理账号"  type="text"></input>
			</view>
			<view :style='{"padding":"12rpx 0","margin":"0 0 24rpx 0","borderColor":"rgb(206, 206, 206)","alignItems":"center","borderWidth":"0 0 2rpx 0","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class="">
				<view :style='{"width":"160rpx","padding":"0 20rpx 0 0","lineHeight":"80rpx","fontSize":"28rpx","color":"#333","textAlign":"right"}' class="title">管理姓名</view>
				<input :style='{"border":"0","padding":"0px 20rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","flex":"1","background":"rgba(255, 255, 255, 0)","fontSize":"28rpx","height":"80rpx"}' :disabled="ro.guanlixingming" v-model="ruleForm.guanlixingming" placeholder="管理姓名"  type="text"></input>
			</view>
             
			<view :style='{"padding":"12rpx 0","margin":"0 0 24rpx 0","borderColor":"rgb(206, 206, 206)","alignItems":"center","borderWidth":"0 0 2rpx 0","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class="">
				<view :style='{"width":"160rpx","padding":"0 20rpx 0 0","lineHeight":"80rpx","fontSize":"28rpx","color":"#333","textAlign":"right"}' class="title">场馆介绍</view>
				<textarea :style='{"border":"0","padding":"20rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","flex":"1","background":"rgba(255, 255, 255, 0)","fontSize":"28rpx","height":"240rpx"}' v-model="ruleForm.changguanjieshao" placeholder="场馆介绍" :maxlength="-1"></textarea>
			</view>
			
			<view :style='{"padding":"20rpx 0","alignItems":"center","flexWrap":"wrap","display":"flex","width":"100%","justifyContent":"center","height":"auto"}' class="btn" >
				<button :style='{"border":"0","padding":"0px","margin":"0 0 20rpx","color":"rgb(255, 255, 255)","background":"#7C6047","width":"60%","lineHeight":"80rpx","fontSize":"28rpx","height":"80rpx"}' @tap="onSubmitTap" class="bg-red">提交</button>
			</view>
		</form>

		<w-picker  mode="dateTime" step="1" :current="false" :hasSecond="false" @confirm="clicktimeConfirm" ref="clicktime" themeColor="#333333"></w-picker>
	</view>
</view>
</template>

<script>
	import wPicker from "@/components/w-picker/w-picker.vue";
	import xiaEditor from '@/components/xia-editor/xia-editor';
	import multipleSelect from "@/components/momo-multipleSelect/momo-multipleSelect";
	export default {
		data() {
			return {
				cross:'',
				ruleForm: {
				changguanmingcheng: '',
				changguanleixing: '',
				changguantupian: '',
				changguanjieshao: '',
				changguanweizhi: '',
				changguanfeiyong: '',
				shijianduan: '',
					changguanzhuangtai: '未预约' ,
				guanlizhanghao: '',
				guanlixingming: '',
				discussnum: '',
				storeupnum: '',
				},
				changguanleixingOptions: [],
				changguanleixingIndex: 0,
				shijianduanOptions: [],
				shijianduanIndex: 0,
				changguanzhuangtaiOptions: [],
				changguanzhuangtaiIndex: 0,
				// 登录用户信息
				user: {},
				ro:{
				   changguanmingcheng : false,
				   changguanleixing : false,
				   changguantupian : false,
				   changguanjieshao : false,
				   changguanweizhi : false,
				   changguanfeiyong : false,
				   shijianduan : false,
				   changguanzhuangtai : false,
				   guanlizhanghao : false,
				   guanlixingming : false,
				   clicktime : false,
				   discussnum : false,
				   storeupnum : false,
				},
				virtualPay: false,
			}
		},
		components: {
			wPicker,
			xiaEditor,
			multipleSelect,
		},
		computed: {
			baseUrl() {
				return this.$base.url;
			},



		},
		async onLoad(options) {
			if(options.virtualPay){
				this.virtualPay = true
			}
			let table = uni.getStorageSync("nowTable");
			// 获取用户信息
			let res = await this.$api.session(table);
			this.user = res.data;
			
			// ss读取
			this.ruleForm.guanlizhanghao = this.user.guanlizhanghao
			this.ro.guanlizhanghao = true;
			this.ruleForm.guanlixingming = this.user.guanlixingming
			this.ro.guanlixingming = true;

			this.ro.changguanzhuangtai = true;

			// 下拉框
			res = await this.$api.option(`changguanleixing`,`changguanleixing`,{});
			this.changguanleixingOptions = res.data;
			this.changguanleixingOptions.unshift("请选择场馆类型");
			// 下拉框
			res = await this.$api.option(`shijianduan`,`shijianduan`,{});
			this.shijianduanOptions = res.data;
			this.shijianduanOptions.unshift("请选择时间段");
			// 自定义下拉框值
			this.changguanzhuangtaiOptions = "已预约,未预约".split(',')

			// 如果有登录，获取登录后保存的userid
			this.ruleForm.userid = uni.getStorageSync("appUserid")
			if (options.refid) {
				// 如果上一级页面传递了refid，获取改refid数据信息
				this.ruleForm.refid = Number(options.refid);
				this.ruleForm.nickname = uni.getStorageSync("nickname");
			}
			// 如果是更新操作
			if (options.id) {
				this.ruleForm.id = options.id;
				// 获取信息
				res = await this.$api.info(`yundongchangguan`, this.ruleForm.id);
				this.ruleForm = res.data;
			}
			// 跨表
			this.cross = options.cross;
			if(options.cross){
				var obj = uni.getStorageSync('crossObj');
				for (var o in obj){
					if(o=='changguanmingcheng'){
						this.ruleForm.changguanmingcheng = obj[o];
						this.ro.changguanmingcheng = true;
						continue;
					}
					if(o=='changguanleixing'){
						this.ruleForm.changguanleixing = obj[o];
						this.ro.changguanleixing = true;
						continue;
					}
					if(o=='changguantupian'){
						this.ruleForm.changguantupian = obj[o].split(",")[0];
						this.ro.changguantupian = true;
						continue;
					}
					if(o=='changguanjieshao'){
						this.ruleForm.changguanjieshao = obj[o];
						this.ro.changguanjieshao = true;
						continue;
					}
					if(o=='changguanweizhi'){
						this.ruleForm.changguanweizhi = obj[o];
						this.ro.changguanweizhi = true;
						continue;
					}
					if(o=='changguanfeiyong'){
						this.ruleForm.changguanfeiyong = obj[o];
						this.ro.changguanfeiyong = true;
						continue;
					}
					if(o=='shijianduan'){
						this.ruleForm.shijianduan = obj[o];
						this.ro.shijianduan = true;
						continue;
					}
					if(o=='changguanzhuangtai'){
						this.ruleForm.changguanzhuangtai = obj[o];
						this.ro.changguanzhuangtai = true;
						continue;
					}
					if(o=='guanlizhanghao'){
						this.ruleForm.guanlizhanghao = obj[o];
						this.ro.guanlizhanghao = true;
						continue;
					}
					if(o=='guanlixingming'){
						this.ruleForm.guanlixingming = obj[o];
						this.ro.guanlixingming = true;
						continue;
					}
					if(o=='clicktime'){
						this.ruleForm.clicktime = obj[o];
						this.ro.clicktime = true;
						continue;
					}
					if(o=='discussnum'){
						this.ruleForm.discussnum = obj[o];
						this.ro.discussnum = true;
						continue;
					}
					if(o=='storeupnum'){
						this.ruleForm.storeupnum = obj[o];
						this.ro.storeupnum = true;
						continue;
					}
				}
			}
			this.styleChange()
			this.$forceUpdate()
			if (uni.getStorageSync('raffleType') && uni.getStorageSync('raffleType') != null) {
				uni.removeStorageSync('raffleType')
				setTimeout(() => {
					this.onSubmitTap()
				}, 300)
			}
		},
		methods: {
			styleChange() {
				this.$nextTick(()=>{
					// document.querySelectorAll('.app-update-pv . .uni-input-input').forEach(el=>{
					//   el.style.backgroundColor = this.addUpdateForm.input.content.backgroundColor
					// })
				})
			},

			// 多级联动参数


			// 日长控件选择日期时间
			clicktimeConfirm(val) {
				console.log(val)
				this.ruleForm.clicktime = val.result;
				this.$forceUpdate();
			},

			// 下拉变化
			changguanleixingChange(e) {
				this.changguanleixingIndex = e.target.value
				this.ruleForm.changguanleixing = this.changguanleixingOptions[this.changguanleixingIndex]
			},
			// 下拉变化
			shijianduanChange(e) {
				this.shijianduanIndex = e.target.value
				this.ruleForm.shijianduan = this.shijianduanOptions[this.shijianduanIndex]
			},
			// 下拉变化
			changguanzhuangtaiChange(e) {
				this.changguanzhuangtaiIndex = e.target.value
				this.ruleForm.changguanzhuangtai = this.changguanzhuangtaiOptions[this.changguanzhuangtaiIndex]
			},

			changguantupianTap() {
				let _this = this;
				this.$api.upload(function(res) {
					_this.ruleForm.changguantupian = 'upload/' + res.file;
					_this.$forceUpdate();
					_this.$nextTick(()=>{
						_this.styleChange()
					})
				});
			},

			getUUID () {
				return new Date().getTime();
			},
			async onSubmitTap() {
				let that = this
				//跨表计算判断
				var obj;
				if(this.ruleForm.changguanfeiyong&&(!this.$validate.isIntNumer(this.ruleForm.changguanfeiyong))){
					this.$utils.msg(`场馆费用应输入整数`);
					return
				}
				if(this.ruleForm.discussnum&&(!this.$validate.isIntNumer(this.ruleForm.discussnum))){
					this.$utils.msg(`评论数应输入整数`);
					return
				}
				if(this.ruleForm.storeupnum&&(!this.$validate.isIntNumer(this.ruleForm.storeupnum))){
					this.$utils.msg(`收藏数应输入整数`);
					return
				}
				//更新跨表属性
				var crossuserid;
				var crossrefid;
				var crossoptnum;
				if(this.cross){
					uni.setStorageSync('crossCleanType',true);
					var statusColumnName = uni.getStorageSync('statusColumnName');
					var statusColumnValue = uni.getStorageSync('statusColumnValue');
					if(statusColumnName!='') {
						if(!obj) {
							obj = uni.getStorageSync('crossObj');
						}
						if(!statusColumnName.startsWith("[")) {
							for (var o in obj){
								if(o==statusColumnName){
									obj[o] = statusColumnValue;
								}

							}
							var table = uni.getStorageSync('crossTable');
							await this.$api.update(`${table}`, obj);
						} else {
							   crossuserid=Number(uni.getStorageSync('appUserid'));
							   crossrefid=obj['id'];
							   crossoptnum=uni.getStorageSync('statusColumnName');
							   crossoptnum=crossoptnum.replace(/\[/,"").replace(/\]/,"");
						}
					}
				}
				if(crossrefid && crossuserid) {
					this.ruleForm.crossuserid=crossuserid;
					this.ruleForm.crossrefid=crossrefid;
					let params = {
						page: 1,
						limit:10,
						crossuserid:crossuserid,
						crossrefid:crossrefid,
					}
					let res = await this.$api.list(`yundongchangguan`, params);
					if (res.data.total >= crossoptnum) {
						this.$utils.msg(uni.getStorageSync('tips'));
						uni.removeStorageSync('crossCleanType');
						return false;
					} else {
				//跨表计算
						let oet = {}
						if(this.ruleForm.id){
							await this.$api.update(`yundongchangguan`, this.ruleForm);
						}else{
							oet = await this.$api.add(`yundongchangguan`, this.ruleForm);
						}

						this.$utils.msgBack('提交成功');
					}
				} else {
				//跨表计算
					let oet = {}
					if(this.ruleForm.id){
						await this.$api.update(`yundongchangguan`, this.ruleForm);
					}else{
						oet = await this.$api.add(`yundongchangguan`, this.ruleForm);
					}

					this.$utils.msgBack('提交成功');
				}
			},
			optionsChange(e) {
				this.index = e.target.value
			},
			bindDateChange(e) {
				this.date = e.target.value
			},
			getDate(type) {
				const date = new Date();
				let year = date.getFullYear();
				let month = date.getMonth() + 1;
				let day = date.getDate();
				if (type === 'start') {
					year = year - 60;
				} else if (type === 'end') {
					year = year + 2;
				}
				month = month > 9 ? month : '0' + month;;
				day = day > 9 ? day : '0' + day;
				return `${year}-${month}-${day}`;
			},
			toggleTab(str) {
				if(this.ro[str]){
					return false
				}
				this.$refs[str].show();
			}
		}
	}
</script>

<style lang="scss" scoped>
	.content {
		min-height: calc(100vh - 44px);
		box-sizing: border-box;
	}
</style>
