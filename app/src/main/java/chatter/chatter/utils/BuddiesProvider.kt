package chatter.chatter.utils

import chatter.chatter.artifacts.BaseModel
import chatter.chatter.artifacts.models.Buddy
import java.util.*
import kotlin.collections.ArrayList

/**
 * Chatter
 *
 * Created by bedoy on 6/8/18.
 */
object BuddiesProvider{

    private val elements : ArrayList<Buddy> = ArrayList()

    init {

        var buddy = Buddy()
        buddy.avatar = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSBCh6K-Bmn0bqrkL5b8Z68PIPC7n7_15HA8HP6tjHNr51MUlVc"
        buddy.nickname = "M4rtha Fisher"
        buddy.identifier = UUID.nameUUIDFromBytes(buddy.nickname?.toByteArray()).toString()
        elements.add(buddy)

        buddy = Buddy()
        buddy.avatar = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQMlruxJ9XABqNSoxC8lHr9M5SKk6vpt7BPl4tSvo-tkU9SR7lx"
        buddy.nickname = "John Shave"
        buddy.online = true
        buddy.identifier = UUID.nameUUIDFromBytes(buddy.nickname?.toByteArray()).toString()
        elements.add(buddy)

        buddy = Buddy()
        buddy.avatar = "https://americaswhiteboy.com/wp-content/uploads/2014/05/hipster-wtf-music-funny-stupid-brooklyn-weird-guy-dude.jpg"
        buddy.nickname = "Xerox Harrington"
        buddy.identifier = UUID.nameUUIDFromBytes(buddy.nickname?.toByteArray()).toString()
        elements.add(buddy)

        buddy = Buddy()
        buddy.avatar = "https://cdn.cliqueinc.com/posts/235818/everyones-favourite-child-model-is-all-grown-up-2416379.640x0c.jpg"
        buddy.nickname = "Samantha Taylor"
        buddy.identifier = UUID.nameUUIDFromBytes(buddy.nickname?.toByteArray()).toString()
        elements.add(buddy)

        buddy = Buddy()
        buddy.avatar = "https://i.ytimg.com/vi/sQvUBSoqNDo/maxresdefault.jpg"
        buddy.nickname = "Sharon Simpson"
        buddy.identifier = UUID.nameUUIDFromBytes(buddy.nickname?.toByteArray()).toString()
        elements.add(buddy)

        buddy = Buddy()
        buddy.avatar = "https://scontent.fmex4-1.fna.fbcdn.net/v/t1.0-1/c106.0.320.320/p320x320/29598054_10215697743977792_4725360775217611919_n.jpg?_nc_cat=0&_nc_eui2=AeFh5T0a1yxdUXQO8_BSO-57RiIzN2Hhcx9_LNeVO5aRzsEICu99mN3geoAHQ9kpNGhhbmcR7X6H8u4gpaHH1qzOwigzTANw42vH3mTQCneBzw&oh=89eed5dd8c7b80e855a3842b58cb15c0&oe=5BBA9E12"
        buddy.nickname = "Anthony Hanson"
        buddy.online = true
        buddy.identifier = UUID.nameUUIDFromBytes(buddy.nickname?.toByteArray()).toString()
        elements.add(buddy)

        buddy = Buddy()
        buddy.avatar = "https://scontent.fmex4-1.fna.fbcdn.net/v/t1.0-1/c0.31.320.320/p320x320/34690928_2045713898804386_832555208188887040_n.jpg?_nc_cat=0&_nc_eui2=AeEFfolsXKs2pjHSA5SIHgvIMhHsFbWCavHdXk2sctPDLVilhSt5k_HJtD8M0ED-H1qfvDh-DG-TfHXZ1b2V31N1k8zVmcgsbpTJXENYvw635g&oh=32fd7e7c1a749b43c864cbb18b0c67f7&oe=5BB30F03"
        buddy.nickname = "Yum Sheller"
        buddy.identifier = UUID.nameUUIDFromBytes(buddy.nickname?.toByteArray()).toString()
        elements.add(buddy)

        buddy = Buddy()
        buddy.avatar = "https://scontent.fmex4-1.fna.fbcdn.net/v/t1.0-1/c0.0.320.320/p320x320/30712168_1939109029497189_4509876120778178560_n.jpg?_nc_cat=0&_nc_eui2=AeG2cqkFIsAIq_yZYAZfQicbGfSDCO4-ZzOR8OwIymHAjwf92LZpnZlimqzfzvf7930wHjxNbJT28vC6x-SsbNWFxGaz18_ugW50ZULKk6GGaw&oh=c0095705e22ca95ead3e064bed308ca3&oe=5BB1B1A5"
        buddy.nickname = "Peter Vachel"
        buddy.identifier = UUID.nameUUIDFromBytes(buddy.nickname?.toByteArray()).toString()
        elements.add(buddy)

        buddy = Buddy()
        buddy.avatar = "https://scontent.fmex4-1.fna.fbcdn.net/v/t1.0-1/p320x320/13557668_1226768067333790_8893684263873984817_n.jpg?_nc_cat=0&_nc_eui2=AeGNHn8w8AYpXGiXqsL1gFzb21v8olYBS8FFyQyMZp924otfHgQ-dUuvohl99BDVc0JlTCgW16fC80NY1dbYjTyN09IEe0VciZdavNfkvCpSMw&oh=5eacd5139cb57162e35e7d22bfdd6e72&oe=5B7FD90A"
        buddy.nickname = "George Beh"
        buddy.identifier = UUID.nameUUIDFromBytes(buddy.nickname?.toByteArray()).toString()
        elements.add(buddy)

        buddy = Buddy()
        buddy.avatar = "https://scontent.fmex4-1.fna.fbcdn.net/v/t1.0-1/p320x320/31949633_10155417969487703_1985996511212732416_n.jpg?_nc_cat=0&_nc_eui2=AeFBVc4myZaYm8JrJG-UGYnucRUc4l03stkoWseZ1e0Pb9V0ok4JWvo_BP4Xc2m7lDBNI-RX2tCZNff09V_L0Wma6wqSQbpEd8knpQWhRqHhuw&oh=c4b0645461a3fd391fde9167a2fc03cf&oe=5BBA3AAE"
        buddy.nickname = "Shore Phew"
        buddy.online = true
        buddy.identifier = UUID.nameUUIDFromBytes(buddy.nickname?.toByteArray()).toString()
        elements.add(buddy)

        buddy = Buddy()
        buddy.avatar = "https://scontent.fmex4-1.fna.fbcdn.net/v/t1.0-1/c0.0.320.320/p320x320/32699977_838397493028851_8861420681665970176_n.jpg?_nc_cat=0&_nc_eui2=AeFedHQsAlyRl3g1uqCu0tF51gNFWul1eU98uC--09_phoI5sN3FoL2s2v1k9IGbcpoZuEm5B_RT92708a45ZhQDpk4J0YLEH5ATGsvk_u-7Tg&oh=00a1d29fa886e17ce1a1e7c72ee74887&oe=5B76BC1C"
        buddy.nickname = "Jal Pain"
        buddy.identifier = UUID.nameUUIDFromBytes(buddy.nickname?.toByteArray()).toString()
        elements.add(buddy)

        buddy = Buddy()
        buddy.avatar = "https://scontent.fmex4-1.fna.fbcdn.net/v/t1.0-1/p320x320/32082198_874183139433504_3607794424383275008_n.jpg?_nc_cat=0&_nc_eui2=AeE12_J1F5ogRtqOoxb7qdne5PWMq8t3nCytaOHQgXDuyRwihkO6BqfOEJBRLXI7UyGjHqeMRIU_kZjmCZyiAWpvA_07-BXg7NZ1VB9OIlgvxA&oh=5c18c656122289dca49f90a55e070a80&oe=5BB1CC28"
        buddy.nickname = "Red Weer"
        buddy.identifier = UUID.nameUUIDFromBytes(buddy.nickname?.toByteArray()).toString()
        elements.add(buddy)

        buddy = Buddy()
        buddy.avatar = "https://scontent.fmex4-1.fna.fbcdn.net/v/t31.0-8/18673216_1676087679098326_2729213042844911884_o.jpg?_nc_cat=0&_nc_eui2=AeG4_7fVHP4dpqhnoyWIFXEKDfhnzbv_ZzUzrHnMwb9zRuajoaDurBSvqlk4F7xUvL-yaN8rEhRosTWxrzriAZqpqgowN1i1vlwVWCuPfglWjg&oh=9126c3a00bd05247be882236ab7006eb&oe=5BBC7A65"
        buddy.nickname = "Pauline Jackson"
        buddy.identifier = UUID.nameUUIDFromBytes(buddy.nickname?.toByteArray()).toString()
        elements.add(buddy)

        buddy = Buddy()
        buddy.avatar = "https://scontent.fmex4-1.fna.fbcdn.net/v/t1.0-1/c4.0.320.320/p320x320/33748331_2486054888087528_1948593341838917632_n.jpg?_nc_cat=0&_nc_eui2=AeF_5XGJ1fTSObsOUVemckEk-D95d2cY0Xa8CCIhCgTvB71TEB5cojZvq4tI_gyZPEwxaaKPMGRIZKw6sUPmOdBzxzQeXynWY6SjY8kt_SEh1A&oh=9ed2306972b97d8d06eb6560548dfebf&oe=5BC0B669"
        buddy.nickname = "Carlos Bedoy"
        buddy.online = true
        buddy.identifier = UUID.nameUUIDFromBytes(buddy.nickname?.toByteArray()).toString()
        elements.add(buddy)

        buddy = Buddy()
        buddy.avatar = "https://scontent.fmex4-1.fna.fbcdn.net/v/t1.0-1/p320x320/20431602_10213824711637055_1311280232080022405_n.jpg?_nc_cat=0&_nc_eui2=AeF6_NUo5FELXUYsTpEi_N_8LUvIiRtNX_nVVPVvTJs-0J20RUGZO3lptXRsHfh6F67dnQzabXSkyVetxw_fXcuQs6u87o2wFoux3Ec-Rpft-A&oh=90eaeb1e171c52128a15dfa37e56bbea&oe=5BBC7936"
        buddy.nickname = "Alexxander Peri"
        buddy.identifier = UUID.nameUUIDFromBytes(buddy.nickname?.toByteArray()).toString()
        elements.add(buddy)

        buddy = Buddy()
        buddy.avatar = "https://scontent.fmex4-1.fna.fbcdn.net/v/t1.0-1/c0.0.320.320/p320x320/29541537_1611620572226889_6170931955223090183_n.jpg?_nc_cat=0&_nc_eui2=AeGd4-3ju2Fm7cyjwZatyuLya51iK2335Z3tS66YzQZsBabQoNNvhl4qfMU2zRNSzPfqMEtcQD_n9_nGhz2TqxFd5Gv9JHfQflGT_WmhVlDPEA&oh=a2fbb905a0e04a99866a5d154b802d8b&oe=5B7975AC"
        buddy.nickname = "Blossom Barrow"
        buddy.identifier = UUID.nameUUIDFromBytes(buddy.nickname?.toByteArray()).toString()
        elements.add(buddy)

        buddy = Buddy()
        buddy.avatar = "https://scontent.fmex4-1.fna.fbcdn.net/v/t1.0-1/p320x320/34453403_1948649651813987_1671559219578404864_n.jpg?_nc_cat=0&_nc_eui2=AeHcgJwtp2lDEP-m0Tydv01Rqo96hxSaitnUWhLs8yTYptEughH_B4kx_Nh2Nfw39ndGDwJeVtIPrY-fPM1yFBZkC1yN8nAuhamAuEd2AsmOvg&oh=b2e611ff24573eb435f6f7e8aac34731&oe=5B77CA78"
        buddy.nickname = "Gernen Green"
        buddy.identifier = UUID.nameUUIDFromBytes(buddy.nickname?.toByteArray()).toString()
        elements.add(buddy)

        buddy = Buddy()
        buddy.avatar = "https://scontent.fmex4-1.fna.fbcdn.net/v/t1.0-1/p320x320/14462891_10207747476064590_2866288375139844574_n.jpg?_nc_cat=0&_nc_eui2=AeFgKDtgsL3uZ4LrPt2p7LQMbegRLwnLbv0WQbar8sBRK3LBsZ4BwHUKgJ4AXiOsqsBPYwyEQxW4qzyhgKd5LYYrzjyWmE2sUxPt7kqaLYdOBQ&oh=037d8f81b45f961a56a691edc4e15f95&oe=5B7ED53F"
        buddy.nickname = "Orion Ocean"
        buddy.identifier = UUID.nameUUIDFromBytes(buddy.nickname?.toByteArray()).toString()
        elements.add(buddy)
    }


    fun fakeBuddies() = elements
}