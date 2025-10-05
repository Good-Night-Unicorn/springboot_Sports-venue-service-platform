<template>
	<view class="content">
		<view class="box" :style='{"width":"100%","padding":"0","alignItems":"flex-end","background":"url(http://codegen.caihongy.cn/20241223/0ecd17ac586d45bc926c2283592d2eec.png) center center/100% 100%","display":"flex","height":"100%"}'>
			<view :style='{"padding":"24rpx 0","margin":"0 auto","flexWrap":"wrap","display":"flex","width":"80%","position":"relative","height":"auto"}'>
				<image :style='{"width":"160rpx","margin":"0 auto 24rpx auto","borderRadius":"8rpx","display":"none","height":"160rpx"}' src="http://codegen.caihongy.cn/20201114/7856ba26477849ea828f481fa2773a95.jpg" mode="aspectFill"></image>
				<view v-if="loginType==1" :style='{"border":"2rpx solid #7C6047","margin":"0 0 24rpx 0","borderWidth":"0 0 2rpx","display":"flex","width":"100%","height":"auto","order":"2"}' class="uni-form-item uni-column">
					<view :style='{"width":"140rpx","padding":"0 10rpx","lineHeight":"70rpx","fontSize":"24rpx","color":"#000"}' class="label">账号：</view>
					<input v-model="username" :style='{"border":"0px solid rgb(255, 170, 51)","padding":"0 20rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","flex":"1","background":"rgb(255, 255, 255)","fontSize":"28rpx","height":"70rpx"}' type="text" class="uni-input" name="" placeholder="请输入账号" />
				</view>
				<view v-if="loginType==1" :style='{"border":"2rpx solid #7C6047","margin":"0 0 24rpx 0","borderWidth":"0 0 2rpx","display":"flex","width":"100%","height":"auto","order":"2"}' class="uni-form-item uni-column">
					<view :style='{"width":"140rpx","padding":"0 10rpx","lineHeight":"70rpx","fontSize":"24rpx","color":"#000"}' class="label">密码：</view>
					<input v-model="password" :style='{"border":"0px solid rgb(255, 170, 51)","padding":"0 20rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","flex":"1","background":"rgb(255, 255, 255)","fontSize":"28rpx","height":"70rpx"}' type="password" class="uni-input" name="" placeholder="请输入密码" />
				</view>
				<view v-if="roleNum>1" :style='{"border":"2rpx solid #7C6047","margin":"0 0 24rpx 0","borderWidth":"0 0 2rpx","display":"flex","width":"100%","height":"auto","order":"4"}'>
					<view :style='{"width":"140rpx","padding":"0 10rpx","lineHeight":"70rpx","fontSize":"24rpx","color":"#000"}' class="label">用户类型：</view>
					<picker @change="optionsChange" :value="index" :range="options" :style='{"padding":"0 20rpx","lineHeight":"70rpx","fontSize":"28rpx","color":"#7C6047","flex":"1"}'>
						<view class="uni-picker-type">{{options[index]}}</view>
					</picker>
				</view>
				

				
				<button v-if="loginType==1" class="btn-submit" @tap="onLoginTap" type="primary" :style='{"border":"0","padding":"0px","margin":"0 0 24rpx 0","color":"rgb(255, 255, 255)","borderRadius":"0","background":"#7C6047","width":"100%","lineHeight":"70rpx","fontSize":"30rpx","height":"70rpx","order":"6"}'>登陆</button>
				<button v-if="loginType==2" class="btn-submit" @tap="onFaceLoginTap" type="primary" :style='{"border":"0","padding":"0px","margin":"0 0 24rpx 0","color":"rgb(255, 255, 255)","borderRadius":"0","background":"#7C6047","width":"100%","lineHeight":"70rpx","fontSize":"30rpx","height":"70rpx","order":"6"}'>人脸识别登录</button>
				<view class="links" :style='{"margin":"0 0 24rpx 0","flexWrap":"wrap","display":"flex","width":"100%","justifyContent":"space-between","height":"auto","order":"8"}'>
					<view class="link-highlight" @tap="onRegisterTap('yonghu')" :style='{"color":"#7A7A7A","padding":"0 8rpx","fontSize":"28rpx"}'>注册用户</view>
				</view>
				
				<view class="idea1" :style='{"margin":"0 0 30rpx","color":"#fff","textAlign":"center","background":"url(http://codegen.caihongy.cn/20241223/4337d08fb87049478e7627a1b59ffd6b.png) center center/100% 100% no-repeat","display":"block","width":"180rpx","lineHeight":"180rpx","fontSize":"36rpx","height":"180rpx","order":"1"}'>登录</view>
				<view class="idea2" :style='{"width":"100%","background":"red","display":"none","height":"80rpx"}'>idea2</view>
				<view class="idea3" :style='{"width":"100%","background":"red","display":"none","height":"80rpx"}'>idea3</view>
			</view>
		</view>
	</view>
</template>

<script>
	import menu from '@/utils/menu'
	export default {
		data() {
			return {
				username: '',
				password: '',
                loginType:1,
				codes: [{
				  num: 1,
				  color: '#000',
				  rotate: '10deg',
				  size: '16px'
				}, {
				  num: 2,
				  color: '#000',
				  rotate: '10deg',
				  size: '16px'
				}, {
				  num: 3,
				  color: '#000',
				  rotate: '10deg',
				  size: '16px'
				}, {
				  num: 4,
				  color: '#000',
				  rotate: '10deg',
				  size: '16px'
				}],
				options: [
					'请选择登录用户类型',
				],
                optionsValues: [
					'',
                    'yonghu',
				],
				index: 0,
				roleNum:0,

			}
		},
		onLoad() {
			let options = ['请选择登录用户类型'];
			let menus = menu.list();
			this.menuList = menus;
			for(let i=0;i<this.menuList.length;i++){
				if(this.menuList[i].hasFrontLogin=='是'){
					options.push(this.menuList[i].roleName);
					this.roleNum++;
				}
			}
			if(this.roleNum==1) {
				this.index = 1;
			}	
			this.options = options;
			this.styleChange()
		},
		onShow() {
		},
		mounted() {
		},
		methods: {
			styleChange() {
				this.$nextTick(()=>{
					// document.querySelectorAll('.uni-input .uni-input-input').forEach(el=>{
					//   el.style.backgroundColor = this.loginFrom.content.input.backgroundColor
					// })
				})
			},
			onRegisterTap(tableName) {
                uni.setStorageSync("loginTable", tableName);
				this.$utils.jump('../register/register')
			},
			async onLoginTap() {
                if (!this.username) {
					this.$utils.msg('请输入用户名')
					return
				}
                if (!this.password) {
					this.$utils.msg('请输入用户密码')
					return
				}
                if (!this.optionsValues[this.index]) {
					this.$utils.msg('请选择登录用户类型')
					return
				}

				this.loginPost()

			},
			async loginPost() {
				
				let res = await this.$api.login(`${this.optionsValues[this.index]}`, {
					username: this.username,
					password: this.password
				});
				uni.removeStorageSync("useridTag");
				uni.setStorageSync("appToken", res.token);
				uni.setStorageSync("nickname",this.username);
				uni.setStorageSync("nowTable", `${this.optionsValues[this.index]}`);
				res = await this.$api.session(`${this.optionsValues[this.index]}`);
				if(res.data.touxiang) {
				    uni.setStorageSync('headportrait', res.data.touxiang);
				} else if(res.data.headportrait) {
				    uni.setStorageSync('headportrait', res.data.headportrait);
				}
				uni.setStorageSync('userSession',JSON.stringify(res.data))
				// 保存用户id
				uni.setStorageSync("appUserid", res.data.id);
				if(res.data.vip) {
					uni.setStorageSync("vip", res.data.vip);
				}
				uni.setStorageSync("appRole", `${this.options[this.index]}`);
				this.$utils.tab('../index/index');
			},
			optionsChange(e) {
				this.index = e.target.value
			}
		}
	}
</script>

<style lang="scss" scoped>
	page {
		height: 100%;
	}
	
	.content {
		height: 100%;
		box-sizing: border-box;
	}
	
</style>
