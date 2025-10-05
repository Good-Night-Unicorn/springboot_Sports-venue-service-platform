<template>
<mescroll-uni @init="mescrollInit" :up="upOption" :down="downOption" @down="downCallback" @up="upCallback">
	<view class="content">
		<view class="container" :style='{"width":"100%","padding":"0","position":"relative","background":"#fff","height":"100%"}'>
			<swiper :style='{"width":"100%","background":"#fff","height":"360rpx"}' class="swiper" :indicator-dots='false' :autoplay='false' :circular='false' indicator-active-color='#000000' indicator-color='rgba(0, 0, 0, .3)' :duration='500' :interval='5000' :vertical='false'>
				<swiper-item :style='{"width":"100%","background":"#fff","height":"360rpx"}' v-for="(swiper,index) in swiperList" :key="index">
					<image :style='{"width":"100%","objectFit":"cover","display":"block","height":"360rpx"}' mode="aspectFill" v-if="swiper.substring(0,4)=='http'" :src="swiper" @tap="imgView(swiper)"></image>
					<image :style='{"width":"100%","objectFit":"cover","display":"block","height":"360rpx"}' mode="aspectFill" v-else :src="baseUrl+swiper" @tap="imgView(baseUrl+swiper)"></image>
				</swiper-item>
			</swiper>
			<view :style='{"width":"100%","padding":"24rpx","background":"#fff","height":"auto"}' class="detail-content">
				<view :style='{"margin":"10rpx 0","borderColor":"#ccc","alignItems":"center","flexWrap":"wrap","borderWidth":"0","display":"flex","width":"100%","borderStyle":"solid","justifyContent":"space-between","height":"auto"}' class="detail-list-item price priceFavor">
					<view :style='{"padding":"0 200rpx 0 20rpx","background":"url(http://codegen.caihongy.cn/20241224/e7306dd90ac24a37855432af79c185e1.png) center center/100% 100%","display":"flex"}' class="text">
						<text :style='{"color":"#fff","lineHeight":"80rpx","fontSize":"24rpx"}'>￥</text>
						<text :style='{"color":"#fff","lineHeight":"80rpx","fontSize":"36rpx"}'>{{detail.price}}</text>
					</view>
					
					<view :style='{"alignItems":"center","flexDirection":"column","display":"flex"}' v-if="storeupFlag==1" @click="shoucang">
						<text class="icon iconfont icon-shoucang12" :style='{"margin":"0 4rpx 0 0","color":"#fff","borderRadius":"10rpx","textAlign":"center","background":"#DAA362","width":"50rpx","lineHeight":"50rpx","fontSize":"28rpx","height":"50rpx"}'></text>
						<text :style='{"color":"#666","lineHeight":"40rpx","fontSize":"24rpx"}'>已收藏</text>
					</view>
					<view :style='{"alignItems":"center","flexDirection":"column","display":"flex"}' v-if="storeupFlag==0" @click="shoucang">
						<text class="icon iconfont icon-shoucang11" :style='{"margin":"0 4rpx 0 0","color":"#fff","borderRadius":"10rpx","textAlign":"center","background":"#DAA362","width":"50rpx","lineHeight":"50rpx","fontSize":"28rpx","height":"50rpx"}'></text>
						<text :style='{"color":"#666","lineHeight":"40rpx","fontSize":"24rpx"}'>收藏</text>
					</view>
				</view>
				<view :style='{"margin":"10rpx 0","borderColor":"#ccc","borderWidth":"0","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class="detail-list-item title">
					<view :style='{"width":"160rpx","padding":"0 20rpx 0 0","lineHeight":"60rpx","fontSize":"28rpx","color":"#333","textAlign":"right"}' class="lable">赛事名称：</view>
					<view :style='{"padding":"0px","margin":"0px","lineHeight":"60rpx","fontSize":"28rpx","color":"rgb(0, 0, 0)"}' class="text" >{{detail.saishimingcheng}}</view>
				</view>

				<view class="detail-list-item" :style='{"margin":"10rpx 0","borderColor":"#ccc","borderWidth":"0","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}'>
					<view class="lable" :style='{"width":"160rpx","padding":"0 20rpx 0 0","lineHeight":"60rpx","fontSize":"28rpx","color":"#333","textAlign":"right"}'>赛事地点：</view>
					<view class="text" :style='{"padding":"0px","margin":"0px","lineHeight":"60rpx","fontSize":"28rpx","color":"rgb(0, 0, 0)"}' >{{detail.saishididian}}</view>
				</view>
				<view class="detail-list-item" :style='{"margin":"10rpx 0","borderColor":"#ccc","borderWidth":"0","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}'>
					<view class="lable" :style='{"width":"160rpx","padding":"0 20rpx 0 0","lineHeight":"60rpx","fontSize":"28rpx","color":"#333","textAlign":"right"}'>活动时间：</view>
					<view class="text" :style='{"padding":"0px","margin":"0px","lineHeight":"60rpx","fontSize":"28rpx","color":"rgb(0, 0, 0)"}' >{{detail.huodongshijian}}</view>
				</view>
				<view class="detail-list-item" :style='{"margin":"10rpx 0","borderColor":"#ccc","borderWidth":"0","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}'>
					<view class="lable" :style='{"width":"160rpx","padding":"0 20rpx 0 0","lineHeight":"60rpx","fontSize":"28rpx","color":"#333","textAlign":"right"}'>发布人：</view>
					<view class="text" :style='{"padding":"0px","margin":"0px","lineHeight":"60rpx","fontSize":"28rpx","color":"rgb(0, 0, 0)"}' >{{detail.faburen}}</view>
				</view>
				<view class="detail-list-item" :style='{"margin":"10rpx 0","borderColor":"#ccc","borderWidth":"0","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}'>
					<view class="lable" :style='{"width":"160rpx","padding":"0 20rpx 0 0","lineHeight":"60rpx","fontSize":"28rpx","color":"#333","textAlign":"right"}'>报名费：</view>
					<view class="text" :style='{"padding":"0px","margin":"0px","lineHeight":"60rpx","fontSize":"28rpx","color":"rgb(0, 0, 0)"}' >{{detail.baomingfei}}</view>
				</view>
				<view class="detail-list-item" :style='{"margin":"10rpx 0","borderColor":"#ccc","borderWidth":"0","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}'>
					<view class="lable" :style='{"width":"160rpx","padding":"0 20rpx 0 0","lineHeight":"60rpx","fontSize":"28rpx","color":"#333","textAlign":"right"}'>报名要求：</view>
					<view class="text" :style='{"padding":"0px","margin":"0px","lineHeight":"60rpx","fontSize":"28rpx","color":"rgb(0, 0, 0)"}' >{{detail.baomingyaoqiu}}</view>
				</view>
				<view class="detail-list-item" :style='{"margin":"10rpx 0","borderColor":"#ccc","borderWidth":"0","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}'>
					<view class="lable" :style='{"width":"160rpx","padding":"0 20rpx 0 0","lineHeight":"60rpx","fontSize":"28rpx","color":"#333","textAlign":"right"}'>管理账号：</view>
					<view class="text" :style='{"padding":"0px","margin":"0px","lineHeight":"60rpx","fontSize":"28rpx","color":"rgb(0, 0, 0)"}' style="text-decoration: underline" @tap="merchantClick('guanlizhanghao')" >{{detail.guanlizhanghao}}</view>
				</view>
				<view class="detail-list-item" :style='{"margin":"10rpx 0","borderColor":"#ccc","borderWidth":"0","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}'>
					<view class="lable" :style='{"width":"160rpx","padding":"0 20rpx 0 0","lineHeight":"60rpx","fontSize":"28rpx","color":"#333","textAlign":"right"}'>管理姓名：</view>
					<view class="text" :style='{"padding":"0px","margin":"0px","lineHeight":"60rpx","fontSize":"28rpx","color":"rgb(0, 0, 0)"}' >{{detail.guanlixingming}}</view>
				</view>
				<view class="detail-list-item" :style='{"margin":"10rpx 0","borderColor":"#ccc","borderWidth":"0","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}'>
					<view class="lable" :style='{"width":"160rpx","padding":"0 20rpx 0 0","lineHeight":"60rpx","fontSize":"28rpx","color":"#333","textAlign":"right"}'>评论数：</view>
					<view class="text" :style='{"padding":"0px","margin":"0px","lineHeight":"60rpx","fontSize":"28rpx","color":"rgb(0, 0, 0)"}' >{{detail.discussnum}}</view>
				</view>
				<view class="detail-list-item" :style='{"margin":"10rpx 0","borderColor":"#ccc","borderWidth":"0","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}'>
					<view class="lable" :style='{"width":"160rpx","padding":"0 20rpx 0 0","lineHeight":"60rpx","fontSize":"28rpx","color":"#333","textAlign":"right"}'>收藏数：</view>
					<view class="text" :style='{"padding":"0px","margin":"0px","lineHeight":"60rpx","fontSize":"28rpx","color":"rgb(0, 0, 0)"}' >{{detail.storeupnum}}</view>
				</view>
				<view class="detail-list-item" :style='{"margin":"10rpx 0","borderColor":"#ccc","borderWidth":"0","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}'>
					<view class="lable" :style='{"width":"160rpx","padding":"0 20rpx 0 0","lineHeight":"60rpx","fontSize":"28rpx","color":"#333","textAlign":"right"}'>座位总数：</view>
					<view class="text" :style='{"padding":"0px","margin":"0px","lineHeight":"60rpx","fontSize":"28rpx","color":"rgb(0, 0, 0)"}' >{{detail.number}}</view>
				</view>



				<view class="detail-list-item rich" :style='{"margin":"0 0 24rpx 0","borderColor":"#ccc","borderWidth":"0","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}'>
					<view class="lable" :style='{"padding":"0 20rpx 0 0","color":"#333","textAlign":"right","display":"none","width":"160rpx","lineHeight":"80rpx","fontSize":"28rpx"}'>赛事内容：</view>
					<view class="rich-text" :style='{"padding":"20rpx 0","margin":"0"}'>
						<rich-text :nodes="detail.saishineirong"></rich-text>
					</view>
				</view>
				<view class="seat-list">
					<view v-for="(item,index) in numberList " v-bind:key="index" class="seat-item">
						<image @tap="$utils.msg('该座位已被预定')" v-if="selectStr.indexOf(item)>=0" class="seat-icon"
							src="../../static/restaurant-detail/select.png" mode=""></image>
							<image @tap="unselectSeat(index+1)" v-else-if="activeSeat.indexOf('#'+item.replace('号','')+'#')>=0" class="seat-icon"
							src="../../static/restaurant-detail/now.png" mode=""></image>
						<image @tap="selectSeat(index+1)" v-else class="seat-icon" src="../../static/restaurant-detail/unselect.png" mode=""></image>
						<text>{{item}}</text>
					</view>
				</view>
				

				<view class="time-content" :style='{"width":"100%","margin":"0 0 24rpx 0","height":"auto"}'>
					<view class="comoment-header" :style='{"border":"2rpx solid #7C6047","padding":"0 4rpx","alignItems":"center","display":"flex","width":"100%","justifyContent":"space-between","height":"auto"}'>
						<view :style='{"padding":"0 24rpx","lineHeight":"80rpx","fontSize":"28rpx","color":"#7C6047","height":"80rpx"}'>评论</view>
						<view :style='{"padding":"0 20rpx","background":"#7C6047","display":"flex"}' @click="onCommentTap" class="btn-comment-content" style="display: flex;align-items: center;">
							<view :style='{"margin":"0 8rpx 0 0","lineHeight":"70rpx","fontSize":"28rpx","color":"#fff"}' class="cuIcon-add"></view>
							<view :style='{"color":"#fff","lineHeight":"70rpx","fontSize":"28rpx"}'>添加评论</view>
						</view>
					</view>

					<view :style='{"boxShadow":"none","padding":"40rpx 20rpx 20rpx 180rpx","margin":"0","borderColor":"#7C6047","flexWrap":"wrap","borderWidth":"0 0 2rpx","display":"flex","width":"100%","position":"relative","borderStyle":"solid","height":"auto"}' v-for="(item,index) in commentList" v-bind:key="index" class="cu-item comment-item">
						<view :style='{"boxShadow":"0 8rpx 16rpx rgba(0,0,0,.1)","position":"absolute","right":"20rpx","top":"0","background":"#fff"}' v-if="item.istop">
							<span class="icon iconfont icon-jiantou24" :style='{"color":"#000"}'></span>
						</view>
						<view :style='{"alignItems":"center","left":"0","flexDirection":"column","display":"flex","width":"180rpx","position":"absolute","height":"auto"}'>
							<image :style='{"width":"60rpx","margin":"0 8rpx 0 0","borderRadius":"100%","display":"block","height":"60rpx"}' v-if="item.avatarurl" mode="aspectFill" :src="baseUrl+item.avatarurl"></image>
							<view :style='{"color":"#7C6047","lineHeight":"60rpx","fontSize":"22rpx"}' class="text-grey">{{item.nickname}}</view>
						</view>
						<view :style='{"width":"100%","margin":"8rpx 0","lineHeight":"1.5","fontSize":"28rpx","color":"#000","order":"3"}' class="text-gray text-content text-df">
							<rich-text :nodes="item.content"></rich-text>
						</view>
						<view :style='{"margin":"0","alignItems":"center","display":"flex","width":"50%","justifyContent":"flex-start","height":"60rpx","order":"1"}'>
							<view v-if="!comzanChange(item)&&!comcaiChange(item)" :style='{"border":"2rpx solid #7C6047","padding":"0 10rpx","margin":"0 10rpx 0 0","alignItems":"center","borderRadius":"8rpx","display":"flex"}' @click="comzanClick(item)">
								<span class="icon iconfont icon-zan07" :style='{"color":"#7C6047","fontSize":"24rpx","lineHeight":"40rpx"}'></span>
								<span :style='{"fontSize":"28rpx","display":"none"}'>赞</span>
								<span :style='{"color":"#7C6047","fontSize":"24rpx","lineHeight":"40rpx"}'>({{item.thumbsupnum}})</span>
							</view>
							<view v-if="comzanChange(item)" :style='{"padding":"0 10rpx","margin":"0 10rpx 0 0","borderRadius":"8rpx","background":"#7C6047"}' @click="comzanClick(item)">
								<span class="icon iconfont icon-zan11" :style='{"color":"#fff","fontSize":"24rpx","lineHeight":"40rpx"}'></span>
								<span :style='{"color":"#ff0000","fontSize":"28rpx","display":"none"}'>已赞</span>
								<span :style='{"color":"#fff","fontSize":"24rpx","lineHeight":"40rpx"}'>({{item.thumbsupnum}})</span>
							</view>
							<view v-if="!comzanChange(item)&&!comcaiChange(item)" :style='{"border":"2rpx solid #58534E","padding":"0 10rpx","alignItems":"center","borderRadius":"8rpx","display":"flex"}' @click="comcaiClick(item)">
								<span class="icon iconfont icon-cai01" :style='{"color":"#58534E","fontSize":"24rpx","lineHeight":"40rpx"}'></span>
								<span :style='{"fontSize":"28rpx","display":"none"}'>踩</span>
								<span :style='{"color":"#58534E","fontSize":"24rpx","lineHeight":"40rpx"}'>({{item.crazilynum}})</span>
							</view>
							<view v-if="comcaiChange(item)" :style='{"borderRadius":"8rpx","padding":"0 10rpx","background":"#58534E"}' @click="comcaiClick(item)">
								<span class="icon iconfont icon-cai16" :style='{"color":"#fff","fontSize":"24rpx","lineHeight":"40rpx"}'></span>
								<span :style='{"color":"#ff0000","fontSize":"28rpx","display":"none"}'>已踩</span>
								<span :style='{"color":"#fff","fontSize":"24rpx","lineHeight":"40rpx"}'>({{item.crazilynum}})</span>
							</view>
						</view>
						<view :style='{"width":"50%","lineHeight":"60rpx","fontSize":"24rpx","color":"#8F8F8F","textAlign":"right","order":"2"}' class="margin-top-sm text-gray text-df">{{item.addtime}}</view>
						<view v-if="item.reply" :style='{"width":"100%","margin":"8rpx 0","lineHeight":"1.5","fontSize":"28rpx","color":"#000","order":"3"}' class="text-gray text-content text-df">
							回复:<rich-text :nodes="item.reply"></rich-text>
						</view>
						<view style="display: flex;display: flex;justify-content: flex-end;padding: 6rpx 0;" v-if="user&&user.id==item.userid">
							<view style="color: #999;font-size: 16rpx;" @click="delClick(item.id)">删除</view>
						</view>
					</view>
				</view>
				<view class="bottom-content bg-white tabbar border shop" :style='{"width":"100%","padding":"10rpx 0","flexWrap":"wrap","background":"none","display":"flex","height":"auto"}'>
				
					<button :style='{"border":"2rpx solid #7C6047","padding":"0 20rpx","margin":"0 10rpx 10rpx 0","color":"#7C6047","borderRadius":"8rpx","background":"none","width":"auto","fontSize":"26rpx","lineHeight":"60rpx","height":"60rpx"}' v-if="userid&&isAuth('saishihuodong','赛事报名')" @tap="onAcrossTap('saishibaoming','','','','')" class="cu-btn bg-brown round shadow-blur">赛事报名</button>
					<button :style='{"border":"2rpx solid #7C6047","padding":"0 20rpx","margin":"0 10rpx 10rpx 0","color":"#7C6047","borderRadius":"8rpx","background":"none","width":"auto","fontSize":"26rpx","lineHeight":"60rpx","height":"60rpx"}' v-if="!userid&&isAuthFront('saishihuodong','赛事报名')" @tap="onAcrossTap('saishibaoming','','','','')" class="cu-btn bg-brown round shadow-blur">赛事报名</button>
					<button :style='{"border":"2rpx solid #7C6047","padding":"0 20rpx","margin":"0 10rpx 10rpx 0","color":"#7C6047","borderRadius":"8rpx","background":"none","width":"auto","fontSize":"26rpx","lineHeight":"60rpx","height":"60rpx"}' v-if="userid&&isAuth('saishihuodong','赛事动态')" @tap="onAcrossTap('saishidongtai','','','','')" class="cu-btn bg-brown round shadow-blur">赛事动态</button>
					<button :style='{"border":"2rpx solid #7C6047","padding":"0 20rpx","margin":"0 10rpx 10rpx 0","color":"#7C6047","borderRadius":"8rpx","background":"none","width":"auto","fontSize":"26rpx","lineHeight":"60rpx","height":"60rpx"}' v-if="!userid&&isAuthFront('saishihuodong','赛事动态')" @tap="onAcrossTap('saishidongtai','','','','')" class="cu-btn bg-brown round shadow-blur">赛事动态</button>
					<button :style='{"border":"2rpx solid #7C6047","padding":"0 20rpx","margin":"0 10rpx 10rpx 0","color":"#7C6047","borderRadius":"8rpx","background":"none","width":"auto","fontSize":"26rpx","lineHeight":"60rpx","height":"60rpx"}' @tap="onSubmitTap" class="btn-submit cu-btn round bg-red">预定</button>


					<button :style='{"border":"2rpx solid #7C6047","padding":"0 20rpx","margin":"0 10rpx 10rpx 0","color":"#7C6047","borderRadius":"8rpx","background":"none","width":"auto","fontSize":"26rpx","lineHeight":"60rpx","height":"60rpx"}' v-if="userid&&isAuth('saishihuodong','私聊')" @tap="chatClick">联系TA</button>
					<button :style='{"border":"2rpx solid #7C6047","padding":"0 20rpx","margin":"0 10rpx 10rpx 0","color":"#7C6047","borderRadius":"8rpx","background":"none","width":"auto","fontSize":"26rpx","lineHeight":"60rpx","height":"60rpx"}' v-if="!userid&&isAuthFront('saishihuodong','私聊')" @tap="chatClick">联系TA</button>
				</view>
			</view>
		</view>
	</view>
</mescroll-uni>
</template>

<script>
	export default {
		data() {
			return {
				btnColor: ['#409eff','#67c23a','#909399','#e6a23c','#f56c6c','#356c6c','#351c6c','#f093a9','#a7c23a','#104eff','#10441f','#a21233','#503319'],
				id: '',
				detail: {},
				swiperList: [],
				commentList: [],
				mescroll: null, //mescroll实例对象
				downOption: {
					auto: false //是否在初始化后,自动执行下拉回调callback; 默认true
				},
				upOption: {
					noMoreSize: 3, //如果列表已无数据,可设置列表的总数量要大于半页才显示无更多数据;避免列表数据过少(比如只有一条数据),显示无更多数据会不好看; 默认5
					textNoMore: '~ 没有更多了 ~',
				},
				hasNext: true,
				user: {},
				numberList: [],
				selectStr: '',
				activeSeat: '',
				sfshIndex: -1,
				sfshOptions: ['通过','不通过', '待审核'],
				storeupFlag: 0,
				count: 0,
				timer: null,
				title: '',
			}
		},
		components: {
		},
		computed: {
			baseUrl() {
				return this.$base.url;
			},
			SecondToDate: function() {
				var time = this.count;
				if (null != time && "" != time) {
					if (time > 60 && time < 60 * 60) {
						time =
							parseInt(time / 60.0) +
							"分钟" +
							parseInt((parseFloat(time / 60.0) - parseInt(time / 60.0)) * 60) +
							"秒";
					} else if (time >= 60 * 60 && time < 60 * 60 * 24) {
						time =
							parseInt(time / 3600.0) +
							"小时" +
							parseInt(
								(parseFloat(time / 3600.0) - parseInt(time / 3600.0)) * 60
							) +
							"分钟" +
							parseInt(
								(parseFloat(
										(parseFloat(time / 3600.0) - parseInt(time / 3600.0)) * 60
									) -
									parseInt(
										(parseFloat(time / 3600.0) - parseInt(time / 3600.0)) * 60
									)) *
								60
							) +
							"秒";
					} else if (time >= 60 * 60 * 24) {
						time =
							parseInt(time / 3600.0 / 24) +
							"天" +
							parseInt(
								(parseFloat(time / 3600.0 / 24) - parseInt(time / 3600.0 / 24)) *
								24
							) +
							"小时" +
							parseInt(
								(parseFloat(time / 3600.0) - parseInt(time / 3600.0)) * 60
							) +
							"分钟" +
							parseInt(
								(parseFloat(
										(parseFloat(time / 3600.0) - parseInt(time / 3600.0)) * 60
									) -
									parseInt(
										(parseFloat(time / 3600.0) - parseInt(time / 3600.0)) * 60
									)) *
								60
							) +
							"秒";
					} else {
						time = parseInt(time) + "秒";
					}
				}
				return time;
			}
		},
		async onLoad(options) {
			let table = uni.getStorageSync("nowTable");
			// 获取用户信息
			let res = await this.$api.session(table);
			this.user = res.data;
			this.id = options.id;
			// 渲染数据
			this.init();
			this.hasNext = true
			// 重新加载数据
			if (this.mescroll) this.mescroll.resetUpScroll()
			this.btnColor = this.btnColor.sort(()=> {
				return (0.5-Math.random());
			});
		},
		async onShow() {
			this.activeSeat = ''
			// this.init();
			let table = uni.getStorageSync("nowTable");
			let res = await this.$api.session(table);
			this.user = res.data;
			this.getStoreup();
			let cleanType = uni.getStorageSync('discusssaishihuodongCleanType')
			if(cleanType){
				uni.removeStorageSync('discusssaishihuodongCleanType')
				this.mescroll.num = 1
				this.upCallback(this.mescroll)
				this.init(2);
			}
			let selectedType = uni.getStorageSync('selectedType')
			if(selectedType){
				uni.removeStorageSync('selectedType')
				this.mescroll.num = 1
				this.upCallback(this.mescroll)
				this.init();
			}
		},
		methods: {
			imgView(url){
				let arr = []
				for(let x in this.swiperList){
					arr.push(this.swiperList[x].substr(0,4)=='http'?this.swiperList[x]:this.baseUrl + this.swiperList[x])
				}
				uni.previewImage({
					current: url,
					urls: arr
				})
			},
			// 拨打电话
			callClick(row){
				uni.makePhoneCall({
					phoneNumber: row
				})
			},
			// 支付
			onPayTap(){
				let that = this
				if(!this.user){
					this.$utils.msg("请先登录")
					setTimeout(()=>{
						that.$utils.jump('../login/login')
					},1500)
					return false
				}
				uni.setStorageSync('paytable','saishihuodong');
				uni.setStorageSync('payObject',this.detail);
				this.$utils.jump('../pay-confirm/pay-confirm?type=1')
			},
			selectSeat(idx) {
				if(this.activeSeat=="") {
					this.activeSeat = `#${idx<10?'0':''}${idx}#`
				} else {
					this.activeSeat = this.activeSeat + "," + `#${idx<10?'0':''}${idx}#`
				}
			},
			unselectSeat(idx){
				let array = this.activeSeat.split(",");
				let newarray = [];
				for(let i=0;i<array.length;i++){
					if(array[i]!=(`#${idx<10?'0':''}${idx}#`)){
						newarray.push(array[i]);
					}
				}
				this.activeSeat = newarray.join(",");
			},
			onSubmitTap() {
				let that = this
				if(!this.user){
					this.$utils.msg("请先登录")
					setTimeout(()=>{
						that.$utils.jump('../login/login')
					},1500)
					return false
				}
				let _this = this;
				if (!this.activeSeat) {
					this.$utils.msg('请选择要预定的座位');
					return
				}
				uni.showModal({
					title: '提示',
					content: '是否确认预定',
					success: async function(res) {
						if (res.confirm) {
							let activeSeatReplace=_this.activeSeat.replace(/#/g,"")
							if (_this.detail.selected) {
								_this.detail.selected = _this.detail.selected + "," + activeSeatReplace
							} else {
								_this.detail.selected = _this.detail.selected + activeSeatReplace
							}
							let data = {
								orderid: _this.$utils.genTradeNo(),
								tablename: 'saishihuodong',
								userid: _this.user.id,
								goodid: _this.detail.id,
								goodname: _this.detail.saishimingcheng,
								guanlizhanghao: _this.detail.guanlizhanghao,
								picture: _this.swiperList ? _this.swiperList[0] : "",
								buynumber: 1,
								total: 0,
								discounttotal: 0,
								type: 1,
								address: activeSeatReplace,
								activeSeat: activeSeatReplace,
								status: '已支付',
								tablename: 'saishihuodong',
								discountprice: _this.detail.vipprice
							}
							if (_this.detail.price) {
								data['status'] = '未支付'
								data['price'] = _this.detail.price
								data['total'] = data['price'] * activeSeatReplace.split(",").length
								uni.setStorageSync('orderGoods', [data]);
								_this.$utils.jump('../shop-order-confirm/shop-order-confirm?seat=1&type=1');
							} else {
								data['price'] = 0
								await _this.$api.add('orders', data);
								await _this.$api.update('saishihuodong', _this.detail);
								_this.$utils.msgBack('预定成功');
							}
						}
					}
				});
			},
			async merchantClick(name){
				let res = await this.$api.query('changguanguanli',{guanlizhanghao: this.detail.guanlizhanghao})
				this.$utils.jump(`../changguanguanli/detail?id=${res.data.id}`)
			},
			onDetailTap(item) {
				uni.setStorageSync("useridTag",this.userid);
				this.$utils.jump(`./detail?id=${item.id}&userid=`+this.userid)
			},
			// 收藏
			async getStoreup() {
				if(!this.user){
					return false
				}
				let params = {
					page: 1,
					limit: 1,
					refid : this.id,
					tablename : 'saishihuodong',
					userid: this.user.id,
					type: 1,
				}
				let res = await this.$api.list(`storeup`, params);
				this.storeupFlag = res.data.list.length;
			},
			async shoucang(){
				let that = this
				if(!this.user){
					this.$utils.msg("请先登录")
					setTimeout(()=>{
						that.$utils.jump('../login/login')
					},1500)
					return false
				}
				let _this = this;
				let params = {
					page: 1,
					limit: 1,
					refid : _this.detail.id,
					tablename : 'saishihuodong',
					userid: _this.user.id,
					type:1,
				}
				let res = await _this.$api.list(`storeup`, params);
				if (res.data.list.length == 1) {
					let storeupId = res.data.list[0].id;
					uni.showModal({
						title: '提示',
						content: '是否取消',
						success: async function(res) {
							if (res.confirm) {
								_this.detail.storeupnum--
								await _this.$api.update('saishihuodong',_this.detail)
								await _this.$api.del('storeup', JSON.stringify([storeupId]));
								_this.$utils.msg('取消成功');
								_this.getStoreup();
							}
						}
					});
					return;
				}
				uni.showModal({
					title: '提示',
					content: '是否收藏',
					success: async function(res) {
						if (res.confirm) {
							await _this.$api.add('storeup', {
								userid: _this.user.id,
								name: _this.detail.saishimingcheng,
								picture: _this.swiperList[0],
								refid: _this.detail.id,
								tablename: 'saishihuodong',
								type: 1
							});
							_this.detail.storeupnum++
							await _this.$api.update('saishihuodong',_this.detail)
							_this.$utils.msg('收藏成功');
							_this.getStoreup();
						}
					}
				});
			},
			// 跨表
			onAcrossTap(tableName,crossOptAudit,crossOptPay,statusColumnName,tips,statusColumnValue,type=1){
				let that = this
				if(!this.user){
					this.$utils.msg("请先登录")
					setTimeout(()=>{
						that.$utils.jump('../login/login')
					},1500)
					return false
				}
				uni.setStorageSync('crossTable','saishihuodong');
				uni.setStorageSync(`crossObj`, this.detail);
				uni.setStorageSync(`statusColumnName`, statusColumnName);
				uni.setStorageSync(`statusColumnValue`, statusColumnValue);
				uni.setStorageSync(`tips`, tips);
				if(statusColumnName!=''&&!statusColumnName.startsWith("[")) {
					var obj = uni.getStorageSync('crossObj');
					for (var o in obj){
						if(o==statusColumnName && obj[o]==statusColumnValue){
							_this.$utils.msg(tips);
							return
						}
					}
				}
				this.$utils.jump(`../${tableName}/add-or-update?cross=true`);
			},
			// 获取详情
			async init(type=1){
				if(this.timer) {
					clearInterval(this.timer);
				} 
				let res = await this.$api.info('saishihuodong', this.id);
				let reg=new RegExp('http://localhost:8080/springboot93kv0nhb/upload','g')//g代表全部
				if(res.data.saishineirong){
					res.data.saishineirong = res.data.saishineirong.replace(reg, this.$base.url + 'upload');
				}
				this.detail = res.data;
				this.title = this.detail.saishimingcheng
				// 轮播图片
				this.swiperList = this.detail.fengmian ? this.detail.fengmian.split(",") : [];
				

				let numberList = []
				for (let i = 1; i <= this.detail.number; i++) {
					numberList.push(`${i<10?'0':''}${i}号`);
				}
				this.numberList = numberList
				if (this.detail.selected) {
					let selected = this.detail.selected.split(",");
					let selectList = []
					for (let i = 0; i < selected.length; i++) {
						selectList.push(`${selected[i]<10?'0':''}${Number(selected[i])}号`);
					}
					this.selectStr = selectList.join(",")
				}
				if(type==2){
					this.detail.discussnum++
					await this.$api.update('saishihuodong',this.detail)
				}
			},

			// mescroll组件初始化的回调,可获取到mescroll对象
			mescrollInit(mescroll) {
				this.mescroll = mescroll;
			},

			/*下拉刷新的回调 */
			downCallback(mescroll) {
				this.hasNext = true
				mescroll.resetUpScroll()
			},

			/*上拉加载的回调: mescroll携带page的参数, 其中num:当前页 从1开始, size:每页数据条数,默认10 */
			async upCallback(mescroll) {
				let res = await this.$api.list('discusssaishihuodong', {
					page: mescroll.num,
					limit: 10,
					refid: Number(this.id)
				});
				// 如果是第一页数据置空
				if (mescroll.num == 1) this.commentList = [];
				for(let x in res.data.list){
					if(res.data.list[x].content){
						res.data.list[x].content = res.data.list[x].content.replace(/img src/gi,"img style=\"width:100%;\" src")
					}
				}
				this.commentList = this.commentList.concat(res.data.list);
				if (res.data.list.length == 0) this.hasNext = false;
				mescroll.endSuccess(mescroll.size, this.hasNext);

			},
			comzanChange(row){
				if(row.tuserids){
					let arr = String(row.tuserids).split(',')
					for(let x in arr){
						if(arr[x] == this.user.id){
							return true
						}
					}
				}
				return false
			},
			async comzanClick(row){
				if(!this.user){
					return false
				}
				if(!this.comzanChange(row)){
					row.thumbsupnum++
					if(row.tuserids){
						row.tuserids = row.tuserids + ',' + this.user.id
					}else {
						row.tuserids = this.user.id
					}
					await this.$api.update('discusssaishihuodong',row)
					this.$utils.msg('点赞成功');
				}else {
					row.thumbsupnum--
					let arr = String(row.tuserids).split(',')
					for(let x in arr){
						if(arr[x] == this.user.id){
							arr.splice(x,1)
						}
					}
					row.tuserids = arr.join(',')
					await this.$api.update('discusssaishihuodong',row)
					this.$utils.msg('取消成功');
				}
				this.$forceUpdate()
			},
			comcaiChange(row){
				if(row.cuserids){
					let arr = String(row.cuserids).split(',')
					for(let x in arr){
						if(arr[x] == this.user.id){
							return true
						}
					}
				}
				return false
			},
			async comcaiClick(row){
				if(!this.user){
					return false
				}
				if(!this.comcaiChange(row)){
					row.crazilynum++
					if(row.cuserids){
						row.cuserids = row.cuserids + ',' + this.user.id
					}else {
						row.cuserids = this.user.id
					}
					await this.$api.update('discusssaishihuodong',row)
					this.$utils.msg('点踩成功');
				}else {
					row.crazilynum--
					let arr = String(row.cuserids).split(',')
					for(let x in arr){
						if(arr[x] == this.user.id){
							arr.splice(x,1)
						}
					}
					row.cuserids = arr.join(',')
					await this.$api.update('discusssaishihuodong',row)
					this.$utils.msg('取消成功');
				}
				this.$forceUpdate()
			},
			onChatTap() {
				this.$utils.jump('../chat/chat')
			},
			// 下载
			download(url ){
				if(!url){
					return false
				}
				let _this = this;
				url=_this.$base.url +  url;
				uni.downloadFile({
					url: url,
					success: (res) => {
						if (res.statusCode === 200) {
							_this.$utils.msg('下载成功');
							// #ifdef H5
							 window.open(url);
							// #endif
							// #ifndef H5
							uni.saveFile({
								tempFilePath: res.tempFilePath, //临时路径
								success: function(obj) {
									uni.showToast({
										icon: 'success',
										mask: true,
										title: '下载成功' , 
										duration: 2000,
									});
									setTimeout(() => {
										console.log('obj.savedFilePath',obj.savedFilePath);
										var filePath = obj.savedFilePath;
										uni.openDocument({ //新开页面打开文档，支持格式：doc, xls, ppt, pdf, docx, xlsx, pptx。
											filePath: filePath,
											showMenu: true,
											success: function(res) {
												console.log('打开文档成功');
											}
										});
									}, 2000)
								}
							});
							// #endif
						}
					}
				});
			},
			// 添加评论
			async onCommentTap() {
				let that = this
				if(!this.user){
					this.$utils.msg("请先登录")
					setTimeout(()=>{
						that.$utils.jump('../login/login')
					},1500)
					return false
				}
				let res = {}
				let params = {
					page: 1,
					limit: 1,
					status: '已完成',
					goodid: this.detail.id,
					userid: uni.getStorageSync('appUserid'),
				}
				res = await this.$api.list('orders', params);
				if (res.data.list.length == 0) {
					this.$utils.msg('请完成订单后再评论');
					return;
				}
				this.$utils.jump(`../discusssaishihuodong/add-or-update?refid=${this.id}`  + '&virtualPay=1' )
			},
			delClick(id){
				let that = this
				uni.showModal({
					title: '提示',
					content: '是否删除此评论？',
					async success(res) {
						if(res.confirm){
							await that.$api.del('discusssaishihuodong',JSON.stringify([id]))
							that.$utils.msg('删除成功')
							that.detail.discussnum--
							await that.$api.update('saishihuodong',that.detail)
							setTimeout(()=>{
								that.upCallback(that.mescroll)
							},1500)
						}
					}
				})
			},

		}
	}
</script>

<style lang="scss">
	page {
		--animate-duration: 1s;
		--animate-delay: 1s;
		--animate-repeat: 1;
	}

	.content {
		min-height: calc(100vh - 44px);
		box-sizing: border-box;
	}
	
	.seat-list {
		display: flex;
		align-items: center;
		flex-wrap: wrap;
		background: #FFFFFF;
		margin: 20upx;
		border-radius: 20upx;
		padding: 20upx;
		font-size: 30upx;
		.seat-item {
			width: 33.33%;
			display: flex;
			align-items: center;
			flex-direction: column;
			margin-bottom: 20upx;
	
			.seat-icon {
				width: 50upx;
				height: 50upx;
				margin-bottom: 10upx;
			}
		}
	}
	
	audio {
		display: flex;
		flex-direction: column;
	}
	
	.audio /deep/ .uni-audio-default {
		width: inherit;
	}
</style>

