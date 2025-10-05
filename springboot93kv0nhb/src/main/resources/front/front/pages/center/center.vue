<template>
	<view class="content">
		<view :style='{"width":"100%","padding":"0","position":"relative","background":"#fff","height":"100%"}'>
			<view v-if="user&&user.id" :style='{"minHeight":"280rpx","padding":"40rpx 30rpx 0","margin":"0 0 20rpx 0","flexWrap":"wrap","background":"url(http://codegen.caihongy.cn/20241225/392a6ac396904d67a05af06d6b07f973.png) center center/100% 100%","display":"flex","width":"100%","position":"relative","height":"auto"}' @tap="onPageTap('../user-info/user-info')" class="header" v-bind:class="{'status':isH5Plus}">
				<view :style='{"width":"100%","alignItems":"center","flexWrap":"wrap","display":"flex"}' v-if="tableName=='changguanguanli'" class="userinfo">
					<image :style='{"width":"100rpx","padding":"0","margin":"0 20rpx 0 0","borderRadius":"100%","height":"100rpx"}' :src="user.touxiang?baseUrl+user.touxiang:require('../../static/gen/upload.png')"></image>
					<view :style='{"width":"calc(100% - 120rpx)","flexDirection":"column","justifyContent":"center","display":"flex"}' class="info">
						<view :style='{"width":"100%","lineHeight":"40rpx","fontSize":"24rpx","color":"#000"}'>{{user.guanlizhanghao}}<text v-if="user.vip&& user.vip=='是'">(VIP)</text></view>
					</view>
					
					<view :style='{"padding":"20rpx ","margin":"40rpx 0 0","borderRadius":"20rpx 20rpx 0 0","flexDirection":"row","background":"#7C6047","display":"flex","width":"100%","justifyContent":"space-between"}' class="info">
						<view :style='{"width":"100%","lineHeight":"40rpx","fontSize":"24rpx","alignItems":"center","flexDirection":"column","display":"flex"}'>
							<span :style='{"color":"#fff"}'>手机：</span>
							<span :style='{"color":"#fff"}'>{{user.shouji}}</span>
						</view>
						<view :style='{"width":"100%","lineHeight":"40rpx","fontSize":"24rpx","alignItems":"center","flexDirection":"column","display":"flex"}' v-if="user.money">
							<span :style='{"color":"#fff"}'>余额：</span>
							<span :style='{"color":"#fff"}'>{{user.money}}</span>
						</view>
						<view :style='{"width":"100%","lineHeight":"40rpx","fontSize":"24rpx","alignItems":"center","flexDirection":"column","display":"flex"}' v-if="user.jf||user.jf==0">
							<span :style='{"color":"#fff"}'>积分：</span>
							<span :style='{"color":"#fff"}'>{{user.jf}}</span>
						</view>
					</view>
				</view>
				<view :style='{"width":"100%","alignItems":"center","flexWrap":"wrap","display":"flex"}' v-if="tableName=='yonghu'" class="userinfo">
					<image :style='{"width":"100rpx","padding":"0","margin":"0 20rpx 0 0","borderRadius":"100%","height":"100rpx"}' :src="user.touxiang?baseUrl+user.touxiang:require('../../static/gen/upload.png')"></image>
					<view :style='{"width":"calc(100% - 120rpx)","flexDirection":"column","justifyContent":"center","display":"flex"}' class="info">
						<view :style='{"width":"100%","lineHeight":"40rpx","fontSize":"24rpx","color":"#000"}'>{{user.zhanghao}}<text v-if="user.vip&& user.vip=='是'">(VIP)</text></view>
					</view>
					
					<view :style='{"padding":"20rpx ","margin":"40rpx 0 0","borderRadius":"20rpx 20rpx 0 0","flexDirection":"row","background":"#7C6047","display":"flex","width":"100%","justifyContent":"space-between"}' class="info">
						<view :style='{"width":"100%","lineHeight":"40rpx","fontSize":"24rpx","alignItems":"center","flexDirection":"column","display":"flex"}'>
							<span :style='{"color":"#fff"}'>手机：</span>
							<span :style='{"color":"#fff"}'>{{user.shouji}}</span>
						</view>
						<view :style='{"width":"100%","lineHeight":"40rpx","fontSize":"24rpx","alignItems":"center","flexDirection":"column","display":"flex"}' v-if="user.money">
							<span :style='{"color":"#fff"}'>余额：</span>
							<span :style='{"color":"#fff"}'>{{user.money}}</span>
						</view>
						<view :style='{"width":"100%","lineHeight":"40rpx","fontSize":"24rpx","alignItems":"center","flexDirection":"column","display":"flex"}' v-if="user.jf||user.jf==0">
							<span :style='{"color":"#fff"}'>积分：</span>
							<span :style='{"color":"#fff"}'>{{user.jf}}</span>
						</view>
					</view>
				</view>
				<view :style='{"padding":"0 20rpx","alignItems":"center","top":"30rpx","borderRadius":"60rpx","flexDirection":"row","background":"#7C6047","display":"flex","width":"auto","position":"absolute","right":"40rpx","justifyContent":"center","height":"50rpx"}' class="setting">
					<text class="icon iconfont icon-qita6" :style='{"border":"0","margin":"0 10rpx 0 0","color":"#fff","borderRadius":"0","width":"auto","lineHeight":"1","fontSize":"32rpx"}'></text>
					<text :style='{"color":"#fff","lineHeight":"2","fontSize":"24rpx"}'>设置</text>
				</view>
			</view>
			
			<view v-else :style='{"minHeight":"280rpx","padding":"40rpx 30rpx 0","margin":"0 0 20rpx 0","flexWrap":"wrap","background":"url(http://codegen.caihongy.cn/20241225/392a6ac396904d67a05af06d6b07f973.png) center center/100% 100%","display":"flex","width":"100%","position":"relative","height":"auto"}' @tap="loginClick" class="header" v-bind:class="{'status':isH5Plus}">
				<view :style='{"alignItems":"center","color":"#666","display":"flex","width":"100%","fontSize":"36rpx","justifyContent":"center","height":"100%"}'>登录/注册</view>
			</view>
			
			<view :style='{"width":"100%","background":"#fff","height":"auto"}' class="list">
				<view :style='{"width":"100%","height":"auto"}' v-if="user&&user.id">
					<view :style='{"width":"100%","padding":"0 20rpx","background":"black","justifyContent":"space-between","display":"none","height":"auto"}'>
						<view :style='{"color":"#fff","fontSize":"28rpx","lineHeight":"72rpx"}'>我的订单</view>
						<view :style='{"color":"#fff","fontSize":"28rpx","lineHeight":"72rpx"}' @tap="onPageTap('../shop-order/shop-order')">查看全部</view>
					</view>
					<view :style='{"width":"calc(100% - 40rpx)","padding":"20rpx 0 10rpx","margin":"0 auto","background":"#7C6047","display":"flex","height":"auto"}'>
						<view class="list-item" :style='{"alignItems":"center","flex":"1","flexDirection":"column","display":"flex","height":"auto"}' @tap="onPageTap('../shop-order/shop-order?nav=未支付')">
							<span class="icon iconfont icon-kuaijiezhifu" :style='{"color":"#fff","lineHeight":"1","fontSize":"52rpx"}'></span>
							<view :style='{"color":"#fff","lineHeight":"2","fontSize":"28rpx"}' class="title">未支付</view>
						</view>
						<view class="list-item" :style='{"alignItems":"center","flex":"1","flexDirection":"column","display":"flex","height":"auto"}' @tap="onPageTap('../shop-order/shop-order?nav=已支付')">
							<span class="icon iconfont icon-zhifudingjin" :style='{"color":"#fff","lineHeight":"1","fontSize":"52rpx"}'></span>
							<view :style='{"color":"#fff","lineHeight":"2","fontSize":"28rpx"}' class="title">已支付</view>
						</view>
						<view class="list-item" :style='{"alignItems":"center","flex":"1","flexDirection":"column","display":"flex","height":"auto"}' @tap="onPageTap('../shop-order/shop-order?nav=已完成')">
							<span class="icon iconfont icon-yanziwancheng" :style='{"color":"#fff","lineHeight":"1","fontSize":"52rpx"}'></span>
							<view :style='{"color":"#fff","lineHeight":"2","fontSize":"28rpx"}' class="title">已完成</view>
						</view>
						<view class="list-item" :style='{"alignItems":"center","flex":"1","flexDirection":"column","display":"flex","height":"auto"}' @tap="onPageTap('../shop-order/shop-order?nav=已取消')">
							<span class="icon iconfont icon-quxiao16" :style='{"color":"#fff","lineHeight":"1","fontSize":"52rpx"}'></span>
							<view :style='{"color":"#fff","lineHeight":"2","fontSize":"28rpx"}' class="title">已取消</view>
						</view>
						<view class="list-item" :style='{"alignItems":"center","flex":"1","flexDirection":"column","display":"flex","height":"auto"}' @tap="onPageTap('../shop-order/shop-order?nav=已退款')">
							<span class="icon iconfont icon-quxiao09" :style='{"color":"#fff","lineHeight":"1","fontSize":"52rpx"}'></span>
							<view :style='{"color":"#fff","lineHeight":"2","fontSize":"28rpx"}' class="title">已退款</view>
						</view>
						<!-- <view class="list-item" :style='{"alignItems":"center","flex":"1","flexDirection":"column","display":"flex","height":"auto"}' @tap="onPageTap('../shop-order/shop-order?nav=已发货')">
							<span class="icon iconfont icon-menu16" :style='{"color":"#333","lineHeight":"1","fontSize":"36rpx"}'></span>
							<view :style='{"color":"#333","lineHeight":"2","fontSize":"24rpx"}' class="title">已发货</view>
						</view> -->
					</view>
				</view>
				
				<view :style='{"width":"100%","height":"auto"}'>
					<view :style='{"width":"100%","padding":"0 20rpx","background":"black","justifyContent":"space-between","display":"none","height":"auto"}'>
						<view :style='{"color":"#fff","fontSize":"28rpx","lineHeight":"72rpx"}'>我的服务</view>
					</view>
					<view class="me-menu-view">
						<block v-for="item in menuList" v-bind:key="item.roleName">
							<block v-if="role==item.roleName" v-bind:key="menu.menu" v-for="(menu,index) in item.backMenu">
								<block v-bind:key="child.tableName" v-for=" (child,sort) in menu.child">
									<view class="me-menu-item" v-if="child.tableName!='orders/已发货' && child.tableName!='orders/已退款' &&child.tableName!='orders/已取消' && child.tableName!='orders/未支付' && child.tableName!='orders/已支付' && child.tableName!='orders/已完成' && child.tableName!='exampaper' && child.tableName!='examquestion'&& child.tableName!='hasTranslate' " @tap="onPageTap('../'+child.tableName+'/list?userid='+user.id+'&menuJump='+child.menuJump)" hover-class="hover">
										<view class="me-menu-icon" :class="child.appFrontIcon"></view>
										<view class="text">{{child.menu}}</view>
										<view class="icon iconfont icon-jinru"></view>
									</view>
								</block>
							</block>
						</block>
						<view v-if="user&&user.id" @tap="onPageTap('../shop-recharge/pay-confirm')" class="me-menu-item" hover-class="hover">
							<view class="cuIcon-moneybag me-menu-icon"></view>
							<view class="text">用户充值</view>
							<view class="icon iconfont icon-jinru"></view>
						</view>
						<view v-if="user&&user.id" @tap="passwordShow()" class="me-menu-item" hover-class="hover">
							<view class="cuIcon-lock me-menu-icon"></view>
							<view class="text">修改密码</view>
							<view class="icon iconfont icon-jinru"></view>
						</view>
					</view>
				</view>
			</view>
			
			<!-- 推荐 -->
			<view style="width: 100%;height: 80px"></view>
		</view>
		<uni-popup class="popup-content" ref="passwordPopup" type="bottom">
			<view class="passwordForm">
				<view class="passwordInput">
					<input type="password" v-model="passwordForm.mima" placeholder="原密码" />
				</view>
				<view class="passwordInput">
					<input type="password" v-model="passwordForm.newmima" placeholder="新密码" />
				</view>
				<view class="passwordInput">
					<input type="password" v-model="passwordForm.newmima1" placeholder="确认密码" />
				</view>
				<view class="passwordBtnView">
					<button class="passwordBtn" @click="updatePassword">更新</button>
				</view>
			</view>
		</uni-popup>
	</view>
</template>
<script>
	import menu from '@/utils/menu'
	export default {
		data() {
			return {
				isH5Plus: true,
				user: {},
				tableName:'',
				role: '',
				menuList: [],
				iconArr: [
					'cuIcon-same',
					'cuIcon-deliver',
					'cuIcon-evaluate',
					'cuIcon-shop',
					'cuIcon-ticket',
					'cuIcon-cascades',
					'cuIcon-discover',
					'cuIcon-question',
					'cuIcon-pic',
					'cuIcon-filter',
					'cuIcon-footprint',
					'cuIcon-pulldown',
					'cuIcon-pullup',
					'cuIcon-moreandroid',
					'cuIcon-refund',
					'cuIcon-qrcode',
					'cuIcon-remind',
					'cuIcon-profile',
					'cuIcon-home',
					'cuIcon-message',
					'cuIcon-link',
					'cuIcon-lock',
					'cuIcon-unlock',
					'cuIcon-vip',
					'cuIcon-weibo',
					'cuIcon-activity',
					'cuIcon-friendadd',
					'cuIcon-friendfamous',
					'cuIcon-friend',
					'cuIcon-goods',
					'cuIcon-selection'
				],
				passwordForm: {
					mima: '',
					newmima: '',
					newmima1: '',
				},
			};
		},
		computed: {
			baseUrl() {
				return this.$base.url;
			},
		},
		async onLoad(){
			let menus = menu.list();
			this.menuList = menus;
			this.meMenuColor = this.meMenuColor.sort(()=> {
				return (0.5-Math.random());
			});
		},
		async onShow(){
            uni.removeStorageSync("useridTag");
			this.role = uni.getStorageSync("appRole");
			await this.getSession()
			this.getThumbsup()
			this.getStoreup()
			this.tableName = uni.getStorageSync("nowTable");
			let menus = menu.list();
			this.menuList = menus;
			this.$forceUpdate()
		},
		methods: {
			async getSession(){
				let table = uni.getStorageSync("nowTable");
				let res = await this.$api.session(table);
				this.user = res.data;
				this.$forceUpdate()
			},
			async getThumbsup(){
				if(!this.user||!this.user.id){
					return false
				}
				let res = await this.$api.page('storeup',{userid: this.user.id,type: 21})
				this.user.thumbsnum = Number(res.data.total)
				this.$forceUpdate()
			},
			async getStoreup(){
				if(!this.user||!this.user.id){
					return false
				}
				let res = await this.$api.page('storeup',{userid: this.user.id,type: 1})
				this.user.storenum = Number(res.data.total)
				this.$forceUpdate()
			},
			loginClick(){
				uni.navigateTo({
					url: '../login/login'
				});
			},
			onPageTap(url) {
                uni.setStorageSync("useridTag",1);
				uni.navigateTo({
					url: url,
					fail: function() {
						uni.switchTab({
							url: url
						});
					}
				});
			},
			hasTranslate(){
				for(let x in this.menuList){
					if(this.menuList[x].roleName == this.role){
						for(let i in this.menuList[x].backMenu){
							if(this.menuList[x].backMenu[i].tableName=='hasTranslate'){
								return true
							}
						}
					}
				}
				return false
			},
			passwordShow() {
				this.passwordForm = {
					mima: '',
					newmima: '',
					newmima1: '',
				}
				this.$forceUpdate()
				this.$refs.passwordPopup.open()
			},
			async updatePassword() {
				if (this.passwordForm.mima == ''){
					this.$utils.msg('原密码不能为空')
					return false
				}
				if (this.passwordForm.newmima == ''){
					this.$utils.msg('新密码不能为空')
					return false
				}
				if (this.passwordForm.newmima1 == ''){
					this.$utils.msg('确认密码不能为空')
					return false
				}
				let password = ''
				if (this.user.mima) {
					password = this.user.mima;
				} else if (this.user.password) {
					password = this.user.password;
				}
				if (this.tableName == 'yonghu') {
				}
				let newpassword = this.passwordForm.mima
				if(password != newpassword){
					this.$utils.msg('原密码不正确')
					return false
				}
				if (this.passwordForm.newmima != this.passwordForm.newmima1){
					this.$utils.msg('两次密码不一致')
					return false
				}
				if (this.passwordForm.mima == this.passwordForm.newmima){
					this.$utils.msg('新密码与原密码相同！')
					return false
				}
				this.user.password = this.passwordForm.newmima
				this.user.mima = this.passwordForm.newmima
				await this.$api.update(this.tableName,this.user)
				this.$utils.msg('修改密码成功,下次登录系统生效')
				this.$refs.passwordPopup.close()
				this.getSession()
			},
		}
	}
</script>

<style lang="scss" scoped>
	.content {
		height: calc(100vh - 94px);
		box-sizing: border-box;
	}
	.passwordForm {
		width: 100%;
		padding: 10px 20px 60px;
		background: #fff;
	
		.passwordInput {
			background: #eee;
			margin: 0 0 10px;
			padding: 0 10px;
	
			input {
				height: 36px;
				line-height: 36px;
				font-size: 14px;
			}
		}
	
		.passwordBtnView {
			width: 100%;
			display: flex;
			align-items: center;
			justify-content: center;
			padding: 10px 0;
	
			.passwordBtn {
				padding: 0 20px;
				width: auto;
				height: 20px;
				line-height: 20px;
				font-size: 14px;
				color: #fff;
				background: #007aff;
				border: none;
				border-radius: 5px;
	
			}
		}
	}
	.me-menu-view {
		padding: 0 0;
		margin: 20rpx auto;
		display: flex;
		width: calc(100% - 40rpx);
		flex-wrap: wrap;
		height: auto;
		.me-menu-item {
			padding: 30rpx 0 0;
			margin: 0 1%;
			flex-direction: column;
			display: flex;
			width: 23%;
			border-color: #7C6047;
			border-width: 0 0 2rpx;
			align-items: center;
			border-style: solid;
			height: auto;
			.me-menu-icon {
				color: #7C6047;
				font-weight: bold;
				font-size: 48rpx;
				line-height: 1;
			}
			.text {
				padding: 0;
				overflow: hidden;
				color: #333;
				white-space: nowrap;
				flex: 1;
				width: 100%;
				font-size: 24rpx;
				line-height: 60rpx;
				text-overflow: ellipsis;
				text-align: center;
			}
			.icon {
				color: #999;
				display: none;
				width: 28rpx;
				font-size: 28rpx;
				line-height: 28rpx;
			}
		}
	}
</style>
