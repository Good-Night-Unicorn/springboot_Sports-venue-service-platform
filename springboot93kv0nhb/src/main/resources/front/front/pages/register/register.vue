<template>
<view class="content">
	<view class="box" :style='{"width":"100%","padding":"0","alignItems":"flex-end","background":"url(http://codegen.caihongy.cn/20241223/0ecd17ac586d45bc926c2283592d2eec.png) center center/100% 100%","display":"flex","height":"100%"}'>
		<view :style='{"padding":"24rpx 0","margin":"0 auto","flexWrap":"wrap","display":"flex","width":"80%","position":"relative","height":"auto"}'>
			<image :style='{"width":"160rpx","margin":"0 auto 24rpx auto","borderRadius":"8rpx","display":"none","height":"160rpx"}' src="http://codegen.caihongy.cn/20201114/7856ba26477849ea828f481fa2773a95.jpg" mode="aspectFill"></image>
			<view :style='{"border":"2rpx solid #7C6047","margin":"0 0 24rpx 0","borderWidth":"0 0 2rpx","display":"flex","width":"100%","height":"auto","order":"2"}' v-if="tableName=='changguanguanli'" class="uni-form-item uni-column">
				<view :style='{"width":"140rpx","padding":"0 10rpx","lineHeight":"70rpx","fontSize":"24rpx","color":"#000"}' class="label">管理账号：</view>
				<input :style='{"border":"0px solid rgb(255, 170, 51)","padding":"0 20rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","flex":"1","background":"rgb(255, 255, 255)","fontSize":"28rpx","height":"70rpx"}'  v-model="ruleForm.guanlizhanghao"  type="text"  class="uni-input" name="" placeholder="管理账号" />
			</view>
			<view :style='{"border":"2rpx solid #7C6047","margin":"0 0 24rpx 0","borderWidth":"0 0 2rpx","display":"flex","width":"100%","height":"auto","order":"2"}' v-if="tableName=='changguanguanli'" class="uni-form-item uni-column">
				<view :style='{"width":"140rpx","padding":"0 10rpx","lineHeight":"70rpx","fontSize":"24rpx","color":"#000"}' class="label">密码：</view>
				<input :style='{"border":"0px solid rgb(255, 170, 51)","padding":"0 20rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","flex":"1","background":"rgb(255, 255, 255)","fontSize":"28rpx","height":"70rpx"}'  v-model="ruleForm.mima" type="password"  class="uni-input" name="" placeholder="密码" />
			</view>
			<view :style='{"border":"2rpx solid #7C6047","margin":"0 0 24rpx 0","borderWidth":"0 0 2rpx","display":"flex","width":"100%","height":"auto","order":"2"}' v-if="tableName=='changguanguanli'" class="uni-form-item uni-column">
				<view :style='{"width":"140rpx","padding":"0 10rpx","lineHeight":"70rpx","fontSize":"24rpx","color":"#000"}' class="label">确认密码：</view>
				<input :style='{"border":"0px solid rgb(255, 170, 51)","padding":"0 20rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","flex":"1","background":"rgb(255, 255, 255)","fontSize":"28rpx","height":"70rpx"}' v-model="ruleForm.mima2" type="password" class="uni-input" name="" placeholder="确认密码" />
			</view>
			<view :style='{"border":"2rpx solid #7C6047","margin":"0 0 24rpx 0","borderWidth":"0 0 2rpx","display":"flex","width":"100%","height":"auto","order":"2"}' v-if="tableName=='changguanguanli'" class="uni-form-item uni-column">
				<view :style='{"width":"140rpx","padding":"0 10rpx","lineHeight":"70rpx","fontSize":"24rpx","color":"#000"}' class="label">管理姓名：</view>
				<input :style='{"border":"0px solid rgb(255, 170, 51)","padding":"0 20rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","flex":"1","background":"rgb(255, 255, 255)","fontSize":"28rpx","height":"70rpx"}'  v-model="ruleForm.guanlixingming"  type="text"  class="uni-input" name="" placeholder="管理姓名" />
			</view>
            <view :style='{"border":"2rpx solid #7C6047","margin":"0 0 24rpx 0","borderWidth":"0 0 2rpx","display":"flex","width":"100%","height":"auto","order":"2"}' v-if="tableName=='changguanguanli'" class="">
				<view :style='{"width":"140rpx","padding":"0 10rpx","lineHeight":"70rpx","fontSize":"24rpx","color":"#000"}' class="label">性别：</view>
				<picker :style='{"width":"calc(100% - 140rpx)","margin":"0 0 24rpx 0","display":"flex","height":"auto"}' v-if="tableName=='changguanguanli'"  @change="changguanguanlixingbieChange" :value="changguanguanlixingbieIndex" :range="changguanguanlixingbieOptions">
					<view>
						<view :style='{"padding":"0 20rpx","lineHeight":"70rpx","fontSize":"28rpx","color":"#7C6047","flex":"1"}' class="uni-input">{{ruleForm.xingbie?ruleForm.xingbie:"请选择性别"}}</view>
					</view>
				</picker>
			</view>
            <view :style='{"border":"2rpx solid #7C6047","margin":"0 0 24rpx 0","borderWidth":"0 0 2rpx","display":"flex","width":"100%","height":"auto","order":"2"}' v-if="tableName=='changguanguanli'" @tap="changguanguanlitouxiangTap" class="">
				<view :style='{"width":"140rpx","padding":"0 10rpx","lineHeight":"70rpx","fontSize":"24rpx","color":"#000"}' class="label">头像：</view>
				<image :style='{"width":"100rpx","borderRadius":"16rpx","display":"block","height":"100rpx"}' v-if="ruleForm.touxiang" class="avator" :src="baseUrl+ruleForm.touxiang" mode=""></image>
                <image :style='{"width":"100rpx","borderRadius":"16rpx","display":"block","height":"100rpx"}' v-else class="avator" src="../../static/gen/upload.png" mode=""></image>
            </view>
			<view :style='{"border":"2rpx solid #7C6047","margin":"0 0 24rpx 0","borderWidth":"0 0 2rpx","display":"flex","width":"100%","height":"auto","order":"2"}' v-if="tableName=='changguanguanli'" class="uni-form-item uni-column">
				<view :style='{"width":"140rpx","padding":"0 10rpx","lineHeight":"70rpx","fontSize":"24rpx","color":"#000"}' class="label">手机：</view>
				<input :style='{"border":"0px solid rgb(255, 170, 51)","padding":"0 20rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","flex":"1","background":"rgb(255, 255, 255)","fontSize":"28rpx","height":"70rpx"}'  v-model="ruleForm.shouji"  type="text"  class="uni-input" name="" placeholder="手机" />
			</view>
			<view :style='{"border":"2rpx solid #7C6047","margin":"0 0 24rpx 0","borderWidth":"0 0 2rpx","display":"flex","width":"100%","height":"auto","order":"2"}' v-if="tableName=='yonghu'" class="uni-form-item uni-column">
				<view :style='{"width":"140rpx","padding":"0 10rpx","lineHeight":"70rpx","fontSize":"24rpx","color":"#000"}' class="label">账号：</view>
				<input :style='{"border":"0px solid rgb(255, 170, 51)","padding":"0 20rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","flex":"1","background":"rgb(255, 255, 255)","fontSize":"28rpx","height":"70rpx"}'  v-model="ruleForm.zhanghao"  type="text"  class="uni-input" name="" placeholder="账号" />
			</view>
			<view :style='{"border":"2rpx solid #7C6047","margin":"0 0 24rpx 0","borderWidth":"0 0 2rpx","display":"flex","width":"100%","height":"auto","order":"2"}' v-if="tableName=='yonghu'" class="uni-form-item uni-column">
				<view :style='{"width":"140rpx","padding":"0 10rpx","lineHeight":"70rpx","fontSize":"24rpx","color":"#000"}' class="label">密码：</view>
				<input :style='{"border":"0px solid rgb(255, 170, 51)","padding":"0 20rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","flex":"1","background":"rgb(255, 255, 255)","fontSize":"28rpx","height":"70rpx"}'  v-model="ruleForm.mima" type="password"  class="uni-input" name="" placeholder="密码" />
			</view>
			<view :style='{"border":"2rpx solid #7C6047","margin":"0 0 24rpx 0","borderWidth":"0 0 2rpx","display":"flex","width":"100%","height":"auto","order":"2"}' v-if="tableName=='yonghu'" class="uni-form-item uni-column">
				<view :style='{"width":"140rpx","padding":"0 10rpx","lineHeight":"70rpx","fontSize":"24rpx","color":"#000"}' class="label">确认密码：</view>
				<input :style='{"border":"0px solid rgb(255, 170, 51)","padding":"0 20rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","flex":"1","background":"rgb(255, 255, 255)","fontSize":"28rpx","height":"70rpx"}' v-model="ruleForm.mima2" type="password" class="uni-input" name="" placeholder="确认密码" />
			</view>
			<view :style='{"border":"2rpx solid #7C6047","margin":"0 0 24rpx 0","borderWidth":"0 0 2rpx","display":"flex","width":"100%","height":"auto","order":"2"}' v-if="tableName=='yonghu'" class="uni-form-item uni-column">
				<view :style='{"width":"140rpx","padding":"0 10rpx","lineHeight":"70rpx","fontSize":"24rpx","color":"#000"}' class="label">姓名：</view>
				<input :style='{"border":"0px solid rgb(255, 170, 51)","padding":"0 20rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","flex":"1","background":"rgb(255, 255, 255)","fontSize":"28rpx","height":"70rpx"}'  v-model="ruleForm.xingming"  type="text"  class="uni-input" name="" placeholder="姓名" />
			</view>
            <view :style='{"border":"2rpx solid #7C6047","margin":"0 0 24rpx 0","borderWidth":"0 0 2rpx","display":"flex","width":"100%","height":"auto","order":"2"}' v-if="tableName=='yonghu'" class="">
				<view :style='{"width":"140rpx","padding":"0 10rpx","lineHeight":"70rpx","fontSize":"24rpx","color":"#000"}' class="label">性别：</view>
				<picker :style='{"width":"calc(100% - 140rpx)","margin":"0 0 24rpx 0","display":"flex","height":"auto"}' v-if="tableName=='yonghu'"  @change="yonghuxingbieChange" :value="yonghuxingbieIndex" :range="yonghuxingbieOptions">
					<view>
						<view :style='{"padding":"0 20rpx","lineHeight":"70rpx","fontSize":"28rpx","color":"#7C6047","flex":"1"}' class="uni-input">{{ruleForm.xingbie?ruleForm.xingbie:"请选择性别"}}</view>
					</view>
				</picker>
			</view>
			<view :style='{"border":"2rpx solid #7C6047","margin":"0 0 24rpx 0","borderWidth":"0 0 2rpx","display":"flex","width":"100%","height":"auto","order":"2"}' v-if="tableName=='yonghu'" class="uni-form-item uni-column">
				<view :style='{"width":"140rpx","padding":"0 10rpx","lineHeight":"70rpx","fontSize":"24rpx","color":"#000"}' class="label">手机：</view>
				<input :style='{"border":"0px solid rgb(255, 170, 51)","padding":"0 20rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","flex":"1","background":"rgb(255, 255, 255)","fontSize":"28rpx","height":"70rpx"}'  v-model="ruleForm.shouji"  type="text"  class="uni-input" name="" placeholder="手机" />
			</view>
			<view :style='{"border":"2rpx solid #7C6047","margin":"0 0 24rpx 0","borderWidth":"0 0 2rpx","display":"flex","width":"100%","height":"auto","order":"2"}' v-if="tableName=='yonghu'" class="uni-form-item uni-column">
				<view :style='{"width":"140rpx","padding":"0 10rpx","lineHeight":"70rpx","fontSize":"24rpx","color":"#000"}' class="label">邮箱：</view>
				<input :style='{"border":"0px solid rgb(255, 170, 51)","padding":"0 20rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","flex":"1","background":"rgb(255, 255, 255)","fontSize":"28rpx","height":"70rpx"}'  v-model="ruleForm.youxiang"  type="text"  class="uni-input" name="" placeholder="邮箱" />
			</view>
			<view :style='{"border":"2rpx solid #7C6047","margin":"0 0 24rpx 0","borderWidth":"0 0 2rpx","display":"flex","width":"100%","height":"auto","order":"2"}' v-if="tableName=='yonghu'" class="uni-form-item uni-column">
				<view :style='{"width":"140rpx","padding":"0 10rpx","lineHeight":"70rpx","fontSize":"24rpx","color":"#000"}' class="label">身份证：</view>
				<input :style='{"border":"0px solid rgb(255, 170, 51)","padding":"0 20rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","flex":"1","background":"rgb(255, 255, 255)","fontSize":"28rpx","height":"70rpx"}'  v-model="ruleForm.shenfenzheng"  type="text"  class="uni-input" name="" placeholder="身份证" />
			</view>
            <view :style='{"border":"2rpx solid #7C6047","margin":"0 0 24rpx 0","borderWidth":"0 0 2rpx","display":"flex","width":"100%","height":"auto","order":"2"}' v-if="tableName=='yonghu'" @tap="yonghutouxiangTap" class="">
				<view :style='{"width":"140rpx","padding":"0 10rpx","lineHeight":"70rpx","fontSize":"24rpx","color":"#000"}' class="label">头像：</view>
				<image :style='{"width":"100rpx","borderRadius":"16rpx","display":"block","height":"100rpx"}' v-if="ruleForm.touxiang" class="avator" :src="baseUrl+ruleForm.touxiang" mode=""></image>
                <image :style='{"width":"100rpx","borderRadius":"16rpx","display":"block","height":"100rpx"}' v-else class="avator" src="../../static/gen/upload.png" mode=""></image>
            </view>
			<button :style='{"border":"0","padding":"0px","margin":"0 0 24rpx 0","color":"rgb(255, 255, 255)","borderRadius":"0","background":"#7C6047","width":"100%","lineHeight":"70rpx","fontSize":"30rpx","height":"70rpx","order":"6"}' class="btn-submit" @tap="register" type="primary">注册</button>
			
			<view class="idea1" :style='{"margin":"0 0 30rpx","color":"#fff","textAlign":"center","background":"url(http://codegen.caihongy.cn/20241223/4337d08fb87049478e7627a1b59ffd6b.png) center center/100% 100% no-repeat","display":"block","width":"180rpx","lineHeight":"180rpx","fontSize":"36rpx","height":"180rpx","order":"1"}'>注册</view>
			<view class="idea2" :style='{"width":"100%","background":"red","display":"none","height":"80rpx"}'>idea2</view>
			<view class="idea3" :style='{"width":"100%","background":"red","display":"none","height":"80rpx"}'>idea3</view>
		</view>
	</view>
</view>
</template>

<script>
    import multipleSelect from "@/components/momo-multipleSelect/momo-multipleSelect";
	export default {
		data() {
			return {
                changguanguanlixingbieOptions: [],
                changguanguanlixingbieIndex: 0,
                yonghuxingbieOptions: [],
                yonghuxingbieIndex: 0,
				ruleForm: {
                guanlizhanghao: '',
                mima: '',
                guanlixingming: '',
                xingbie: '',
                touxiang: '',
                shouji: '',
				money: 0,
                status: '',
                zhanghao: '',
                mima: '',
                xingming: '',
                xingbie: '',
                shouji: '',
                youxiang: '',
                shenfenzheng: '',
                touxiang: '',
				money: 0,
                status: '',
				},
				tableName:""
			}
		},
        components: {
            multipleSelect
        },
        computed: {
            baseUrl() {
                return this.$base.url;
            },
        },
		async onLoad() {
			let res = [];
			let table = uni.getStorageSync("loginTable");
            this.tableName = table;

                        // 自定义下拉框值
			if(this.tableName=='changguanguanli'){
                this.changguanguanlixingbieOptions = "男,女".split(',');
				this.ruleForm.xingbie=this.changguanguanlixingbieOptions[0]
			}
                        // 自定义下拉框值
			if(this.tableName=='yonghu'){
                this.yonghuxingbieOptions = "男,女".split(',');
				this.ruleForm.xingbie=this.yonghuxingbieOptions[0]
			}
			
			this.styleChange()
		},
		methods: {

            // 下拉变化
            changguanguanlixingbieChange(e) {
                    this.changguanguanlixingbieIndex = e.target.value
                    this.ruleForm.xingbie = this.changguanguanlixingbieOptions[this.changguanguanlixingbieIndex]
            },
            changguanguanlitouxiangTap() {
                let _this = this;
                this.$api.upload(function(res) {
                    _this.ruleForm.touxiang = 'upload/' + res.file;
					_this.$forceUpdate();
                });
            },
            // 下拉变化
            yonghuxingbieChange(e) {
                    this.yonghuxingbieIndex = e.target.value
                    this.ruleForm.xingbie = this.yonghuxingbieOptions[this.yonghuxingbieIndex]
            },
            yonghutouxiangTap() {
                let _this = this;
                this.$api.upload(function(res) {
                    _this.ruleForm.touxiang = 'upload/' + res.file;
					_this.$forceUpdate();
                });
            },

            toggleTab(str) {
                this.$refs[str].show();
            },

			styleChange() {
				this.$nextTick(()=>{
					// document.querySelectorAll('.uni-input .uni-input-input').forEach(el=>{
					//   el.style.backgroundColor = this.registerFrom.content.input.backgroundColor
					// })
				})
			},
			// 获取uuid
			getUUID () {
				return new Date().getTime();
			},
			// 注册
			async register() {
				
				if((!this.ruleForm.guanlizhanghao) && `changguanguanli` == this.tableName){
					this.$utils.msg(`管理账号不能为空`);
					return
				}
				if((!this.ruleForm.mima) && `changguanguanli` == this.tableName){
					this.$utils.msg(`密码不能为空`);
					return
				}
                if(`changguanguanli` == this.tableName && (this.ruleForm.mima!=this.ruleForm.mima2)){
                    this.$utils.msg(`两次密码输入不一致`);
                    return
                }
				if(`changguanguanli` == this.tableName && this.ruleForm.shouji&&(!this.$validate.isMobile(this.ruleForm.shouji))){
					this.$utils.msg(`手机应输入手机格式`);
					return
				}
				if(`changguanguanli` == this.tableName && this.ruleForm.money&&(!this.$validate.isNumber(this.ruleForm.money))){
					this.$utils.msg(`余额应输入数字`);
					return
				}
				if(`changguanguanli` == this.tableName && this.ruleForm.status&&(!this.$validate.isIntNumer(this.ruleForm.status))){
					this.$utils.msg(`状态应输入整数`);
					return
				}
				if((!this.ruleForm.zhanghao) && `yonghu` == this.tableName){
					this.$utils.msg(`账号不能为空`);
					return
				}
				if((!this.ruleForm.mima) && `yonghu` == this.tableName){
					this.$utils.msg(`密码不能为空`);
					return
				}
                if(`yonghu` == this.tableName && (this.ruleForm.mima!=this.ruleForm.mima2)){
                    this.$utils.msg(`两次密码输入不一致`);
                    return
                }
				if(`yonghu` == this.tableName && this.ruleForm.shouji&&(!this.$validate.isMobile(this.ruleForm.shouji))){
					this.$utils.msg(`手机应输入手机格式`);
					return
				}
				if(`yonghu` == this.tableName && this.ruleForm.money&&(!this.$validate.isNumber(this.ruleForm.money))){
					this.$utils.msg(`余额应输入数字`);
					return
				}
				if(`yonghu` == this.tableName && this.ruleForm.status&&(!this.$validate.isIntNumer(this.ruleForm.status))){
					this.$utils.msg(`状态应输入整数`);
					return
				}
				await this.$api.register(`${this.tableName}`, this.ruleForm);
				this.$utils.msgBack('注册成功');;
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
